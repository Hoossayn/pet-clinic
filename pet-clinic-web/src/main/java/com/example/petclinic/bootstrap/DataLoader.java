package com.example.petclinic.bootstrap;

import com.example.petclinic.model.Owner;
import com.example.petclinic.model.Pet;
import com.example.petclinic.model.PetType;
import com.example.petclinic.model.Vet;
import com.example.petclinic.services.OwnerService;
import com.example.petclinic.services.PetTypeService;
import com.example.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader  implements CommandLineRunner {

    private  final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService){
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);


        Owner owner1 = new Owner();
        owner1.setFirstName("Micheal");
        owner1.setLastName("Owen");
        owner1.setAddress("133- fake street");
        owner1.setCity("Lagos");
        owner1.setTelephone("123-423-332-323");
        ownerService.save(owner1);


        Pet mikesPet = new Pet();
        mikesPet.setPetType(saveDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Jumbo");
        owner1.getPets().add(mikesPet);

        Owner owner2 = new Owner();
        owner2.setFirstName("Ferguson");
        owner2.setLastName("Alex");
        owner2.setAddress("133- fake street");
        owner2.setCity("Benin");
        owner2.setTelephone("123-532-332-323");
        ownerService.save(owner2);

        Pet marysCat = new Pet();
        marysCat.setName("Cia");
        marysCat.setOwner(owner2);
        marysCat.setBirthDate(LocalDate.now());
        marysCat.setPetType(saveCatPetType);
        owner2.getPets().add(marysCat);

        System.out.println("loaded owners ....");

        Vet vet1 = new Vet();
        vet1.setFirstName("lsam");
        vet1.setLastName("Alex");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Ejiro");
        vet2.setLastName("Pearson");
        vetService.save(vet2);

        System.out.println("loaded vets ....");

    }
}
