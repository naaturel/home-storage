package be.naaturel.homestorage.mapping;

import be.naaturel.homestorage.infrastucture.DocumentEntity;
import be.naaturel.homestorage.models.Document;

public class DocumentMapper {

    public static DocumentEntity toEntity(Document doc){
        DocumentEntity dao = new DocumentEntity();
        dao.token =  doc.getToken();
        dao.name = doc.getName();
        dao.content = doc.getContent();
        return dao;
    }

}
