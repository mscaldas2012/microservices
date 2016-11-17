package edu.msc.spring.bootstrap;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import lombok.Data;


/**
 * Created by marcelo on 10/7/16.
 */
@Data
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(locations = "classpath:about.yml")
@JsonSerialize(using = AboutSerializer.class)
public class About implements Serializable {
	private String summary;
	private List<ContactInfo> contacts;
	private List<String> versions ;
	private String docs;



	@Data
	public static class ContactInfo {
		private String name;
		private String email;
		private String role;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
	}



	public String getSummary() {
		return summary;
	}



	public void setSummary(String summary) {
		this.summary = summary;
	}



	public List<ContactInfo> getContacts() {
		return contacts;
	}



	public void setContacts(List<ContactInfo> contacts) {
		this.contacts = contacts;
	}



	public List<String> getVersions() {
		return versions;
	}



	public void setVersions(List<String> versions) {
		this.versions = versions;
	}



	public String getDocs() {
		return docs;
	}



	public void setDocs(String docs) {
		this.docs = docs;
	}
}

//Classes annotated wiht Configuration are not serializable out of the box.
//Needed to create this custom Serializer in order to get the About class above properly serialized.
class AboutSerializer extends StdSerializer<About> {

	public AboutSerializer() {
		this(null);
	}

	public AboutSerializer(Class<About> t) {
		super(t);
	}

	@Override
	public void serialize(About about, JsonGenerator jgen, SerializerProvider provider) throws IOException {
		jgen.writeStartObject();
		jgen.writeStringField("summary", about.getSummary());
		jgen.writeFieldName("versions");
		jgen.writeStartArray();
		for (String v: about.getVersions()) {
			jgen.writeString(v);
		}
		jgen.writeEndArray();
		jgen.writeStringField("docs", about.getDocs());
		jgen.writeFieldName("contacts");
		jgen.writeStartArray();
		for (About.ContactInfo c: about.getContacts()) {
			jgen.writeStartObject();
			jgen.writeStringField("name", c.getName());
			jgen.writeStringField("email", c.getEmail());
			jgen.writeStringField("role", c.getRole());
			jgen.writeEndObject();
		}
		jgen.writeEndArray();

		jgen.writeEndObject();
	}
}