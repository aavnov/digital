package com.example.licensecheck;

import com.example.licensecheck.Entity.Inet;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

//import net.novgorod.android.policlinicaclient.entity.ClndrEmpl;

import java.io.IOException;

public class InetDeserializer extends JsonDeserializer<Inet> {


    @Override
    public Inet deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        ObjectCodec oc = jp.getCodec();
        JsonNode node = oc.readTree(jp);


        final String id    = node.get("id").asText(); //findValuesAsText()
        final String master = node.get("name").asText();
        final String date   = node.get("date").asText();
        final String status = node.get("statusOrgn").asText();

/*        Inet clndrEmpl = new Inet();
        //clndrEmpl.setId(Integer.valueOf(id));
        clndrEmpl.setName(master);
        clndrEmpl.setDate(date);
        clndrEmpl.setStatusOrgn(status);*/


        return null;

    }
}
