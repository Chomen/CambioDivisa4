package es.np.ctrl.ops;

import com.google.api.services.sheets.v4.model.ValueRange;
import es.np.ctrl.dto.ClientDTO;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientAccess {

    public static ClientDTO lookupClient(ClientDTO cDTO) throws IOException, GeneralSecurityException, ParseException {

        Map<String,String> map;
        List<Map<String,String>> list = new ArrayList<Map<String,String>>();
        if (cDTO.getClientId()!=0L) {
            map=new HashMap<String,String>();
            map.put("columnName", "clientId");
            map.put("columnValue", String.valueOf(cDTO.getClientId()));
            list.add(map);
        }
        if (cDTO.getPhoneNumber()!=0L) {
            map=new HashMap<String,String>();
            map.put("columnName", "phoneNumber");
            map.put("columnValue", String.valueOf(cDTO.getPhoneNumber()));
            list.add(map);
        }
        if (list.isEmpty())return null;
        int offset=GoogleSheetAccess.lookUpCellOffset(list,"Clientes");
        if (offset==0) return null;
        cDTO=selectClient(offset);
        return cDTO;
    }

    public static ClientDTO selectClient(int offset) throws GeneralSecurityException, IOException, ParseException {
        ClientDTO cDTO = new ClientDTO();
        ValueRange result= GoogleSheetAccess.selectRow("Clientes",offset);
        List<Object> resultRow = result.getValues().get(0);

        return new ClientDTO(resultRow);
    }

    public static ClientDTO addClient(ClientDTO cDTO) throws GeneralSecurityException, IOException, ParseException {

        List<Object> resultRow = cDTO.getResultRow();
        List<List<Object>> listValues= new ArrayList<List<Object>>();
        listValues.add(resultRow);
        String retValue = GoogleSheetAccess.appendRow("Clientes", listValues);
        String[] workUnits = StringUtils.split(StringUtils.substringAfter(retValue, "!"),":");
        cDTO.setClientId(Long.valueOf(workUnits[0].substring(1)));
        return cDTO;
    }
    public static int updateClient(ClientDTO clientDTO,int offset) throws GeneralSecurityException, IOException, ParseException {
        List<Object> resultRow = clientDTO.getResultRow();
        List<List<Object>> listValues= new ArrayList<List<Object>>();
        listValues.add(resultRow);
        return GoogleSheetAccess.updateRow("Clientes",listValues,offset);
    }

}
