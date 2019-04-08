package es.np.ctrl.ops;

import com.google.api.services.sheets.v4.model.ValueRange;
import es.np.ctrl.dto.OperationDTO;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperationAccess {

    public static OperationDTO lookupOperation(OperationDTO oDTO) throws IOException, GeneralSecurityException, ParseException {
        Map<String,String> map;
        List<Map<String,String>> list = new ArrayList<Map<String,String>>();
        if (oDTO.getClientDTO().getClientId()!=0L) {
            map=new HashMap<String,String>();
            map.put("columnName", "clientId");
            map.put("columnValue", String.valueOf(oDTO.getClientDTO().getClientId()));
            list.add(map);
        }
        if (oDTO.getOperationId()!=0L) {
            map=new HashMap<String,String>();
            map.put("columnName", "operationId");
            map.put("columnValue", String.valueOf(oDTO.getOperationId()));
            list.add(map);
        }
        if (list.isEmpty())return null;
        int offset=GoogleSheetAccess.lookUpCellOffset(list,"Operaciones");
        if (offset==0) return null;
        oDTO=selectOperation(offset);
        return oDTO;
    }

    public static OperationDTO selectOperation(int offset) throws GeneralSecurityException, IOException, ParseException {
        OperationDTO oDTO = new OperationDTO();
        ValueRange result= GoogleSheetAccess.selectRow("Operaciones",offset);
        List<Object> resultRow = result.getValues().get(0);
        return new OperationDTO(resultRow);
    }

    public static String addOperation(OperationDTO oDTO) throws GeneralSecurityException, IOException, ParseException {

        List<Object> resultRow = oDTO.getResultRow();
        List<List<Object>> listValues= new ArrayList<List<Object>>();
        listValues.add(resultRow);
        return GoogleSheetAccess.appendRow("Operaciones",listValues);
    }
    public static int updateOperation(OperationDTO operationDTO,int offset) throws GeneralSecurityException, IOException, ParseException {
        List<Object> resultRow = operationDTO.getResultRow();
        List<List<Object>> listValues= new ArrayList<List<Object>>();
        listValues.add(resultRow);
        return GoogleSheetAccess.updateRow("Operaciones",listValues,offset);
    }

}
