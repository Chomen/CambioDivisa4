package es.np.ctrl.ops;

import com.google.api.services.sheets.v4.model.ValueRange;
import es.np.ctrl.dto.DocumentDTO;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DocAccess {
    public static DocumentDTO lookupDocument(DocumentDTO dDTO) throws IOException, GeneralSecurityException, ParseException {

        Map<String,String> map;
        List<Map<String,String>> list = new ArrayList<Map<String,String>>();
        if (dDTO.getDocId()!=0L) {
            map=new HashMap<String,String>();
            map.put("columnName", "docId");
            map.put("columnValue", String.valueOf(dDTO.getDocId()));
            list.add(map);
        }
        if (dDTO.getClientId()!=0L) {
            map=new HashMap<String,String>();
            map.put("columnName", "clientId");
            map.put("columnValue", String.valueOf(dDTO.getClientId()));
            list.add(map);
        }
        if (dDTO.getDocNumber()!=null) {
            map=new HashMap<String,String>();
            map.put("columnName", "docNumber");
            map.put("columnValue", String.valueOf(dDTO.getClientId()));
            list.add(map);
        }
        if (dDTO.getDocType()!=null) {
            map=new HashMap<String,String>();
            map.put("columnName", "docType");
            map.put("columnValue", String.valueOf(dDTO.getDocType()));
            list.add(map);
        }
        if (list.isEmpty())return null;
        int offset=GoogleSheetAccess.lookUpCellOffset(list,"Documentos");
        if (offset==0) return null;
        dDTO=selectDocument(offset);
        return dDTO;
    }

    private static DocumentDTO selectDocument(int offset) throws GeneralSecurityException, IOException, ParseException {

        ValueRange result= GoogleSheetAccess.selectRow("Documentos",offset);
        List<Object> resultRow = result.getValues().get(0);

        return new DocumentDTO(resultRow);
    }
    public static String addDocument(DocumentDTO docDTO) throws GeneralSecurityException, IOException, ParseException {

        List<Object> resultRow = docDTO.getResultRow();
        List<List<Object>> listValues= new ArrayList<List<Object>>();
        listValues.add(resultRow);
        return GoogleSheetAccess.appendRow("Documentos",listValues);
    }
    public static int updateDocument(DocumentDTO docDTO,int offset) throws GeneralSecurityException, IOException, ParseException {

        List<Object> resultRow = docDTO.getResultRow();
        List<List<Object>> listValues= new ArrayList<List<Object>>();
        listValues.add(resultRow);
        return GoogleSheetAccess.updateRow("Documentos",listValues,offset);
    }
}
