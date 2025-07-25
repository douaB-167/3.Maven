package com.MyAzienda.SpringToMany;

import java.time.LocalDate;
import java.util.Date;

import com.MyAzienda.SpringToMany.configurations.DateConfiguration;
import com.MyAzienda.SpringToMany.entities.Photo;
import com.MyAzienda.SpringToMany.entities.PhotoMetadata;
import com.MyAzienda.SpringToMany.entities.Tag;
import com.MyAzienda.SpringToMany.entities.User;
import com.MyAzienda.SpringToMany.repositories.IPhotoMetadataRepository;
import com.MyAzienda.SpringToMany.repositories.IPhotoRepository;
import com.MyAzienda.SpringToMany.repositories.ITagRepository;
import com.MyAzienda.SpringToMany.repositories.IUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringToManyApplication {

    public static void main(String[] args) {
		SpringApplication.run(SpringToManyApplication.class, args);
	}
	
	@Autowired
	private LocalDate currentDate;
	
	@Autowired
	public String currentDateTimeFormatted;
	
	public void printCurrentDate() {
		System.out.println("La data corrente è " + currentDate);
	}

	@Bean
    CommandLineRunner commandLineRunner(IPhotoRepository photoRepository,
                                        IUserRepository userRepository,
                                        ITagRepository tagRepository,
                                        IPhotoMetadataRepository photoMetadataRepository) {
        return args -> {
            boolean IS_CREATE_USER = false;
            if (IS_CREATE_USER) {
                
                // CREATE USER and Photos
                User user1 = new User();
                user1.setName("user 1");
                
                userRepository.save(user1);
                
                for(int i = 1; i < 4; i++) {
                    
                    Photo photo = new Photo();
                    photo.setTitle("Lake Photo n-" + i);
                    photo.setDescription("my description");
                    photo.setUrl("com.MyAzienda.Photos n-" + i );
                    photo.setUser(user1);
                    
                    photoRepository.save(photo);
                }
                
                User user2 = new User();
                user2.setName("user 2");
                
                userRepository.save(user2);
                
                for(int i = 4; i < 7; i++) {
                    
                    Photo photo = new Photo();
                    photo.setTitle("Lake Photo n-" + i);
                    photo.setDescription("my description");
                    photo.setUrl("com.MyAzienda.Photos n-" + i );
                    photo.setUser(user2);
                    
                    photoRepository.save(photo);
                }            
            } /***************** fine IS_CREATE_USER *****************************************/
            
            
            
            
            boolean IS_CREATE_TAG = false;
            if (IS_CREATE_TAG) {
                
                // ADD TAG TO PHOTO ************************************ MY
                Tag tag1 = new Tag();
                tag1.setText("my tag " + System.currentTimeMillis());
                
                tagRepository.save(tag1);
                
                Tag tag2 = new Tag();
                tag2.setText("my tag " + System.currentTimeMillis());
                
                tagRepository.save(tag2);    
                // -------------------------
                Photo photoAddTag = photoRepository.findByTitle("Lake Photo n-1").get();
                
                photoAddTag.getTags().add(tag1);
                photoAddTag.getTags().add(tag2);
                
                photoRepository.save(photoAddTag);
                // -------------------------
                Photo photoAddTag2 = photoRepository.findByTitle("Lake Photo n-2").get();
                
                photoAddTag2.getTags().add(tag1);
                photoAddTag2.getTags().add(tag2);
                
                photoRepository.save(photoAddTag2);
                // -------------------------
                
            } /***************** fine IS_CREATE_TAG *****************************************/
            
        
            
            
            
            
            boolean IS_CREATE_METADATA = false;
            if (IS_CREATE_METADATA) {
                
                // ADD METADATA TO PHOTO ***************************** MY
                Photo photoAddMetadata = photoRepository.findByTitle("Lake Photo n-1").get();
                
                if (photoAddMetadata.getPhotoMetadata() == null) {
                    
                    PhotoMetadata metadata = new PhotoMetadata();
                    metadata.setWidth(100);
                    metadata.setHeight(500);
                    metadata.setCreated(new Date());
                    
                    metadata.setPhoto(photoAddMetadata);
                    
                    photoMetadataRepository.save(metadata);
                    
                    photoAddMetadata = photoRepository.findByTitle("Lake Photo n-1").get();
                }
                
            } /***************** fine IS_CREATE_METADATA *****************************************/
            
            
            System.out.println("La data corrente è: " + currentDate);
            System.out.println("La data-ora corrente è: " + currentDateTimeFormatted);
            
            System.out.println("--------------------------");
        
        }; // fine ..... return args ->
        
    }
}
