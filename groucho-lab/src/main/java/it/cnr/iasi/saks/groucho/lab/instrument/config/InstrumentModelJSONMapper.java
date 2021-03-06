/* 
 * This file is part of the GROUCHO project.
 * 
 * GROUCHO is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * GROUCHO is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with GROUCHO.  If not, see <https://www.gnu.org/licenses/>
 *
 */
package it.cnr.iasi.saks.groucho.lab.instrument.config;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import it.cnr.iasi.saks.groucho.lab.instrument.model.InjectableMethodList;

public class InstrumentModelJSONMapper {
	
	public static InjectableMethodList loadFromJSON (InputStream stream) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();

        // Read JSON file and convert to java object
        InjectableMethodList lst = mapper.readValue(stream, InjectableMethodList.class);
        stream.close();

        return lst;
	}

	public static void saveToJSON (InjectableMethodList lst, OutputStream stream) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();

        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        
        // Save JSON string to file
        mapper.writeValue(stream, lst);
        stream.close();
     }

	public static String saveToJSON (InjectableMethodList lst) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();

     // Convert object to JSON string
        String lstJson = mapper.writeValueAsString(lst);
        return lstJson;
	}
}
