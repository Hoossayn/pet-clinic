package com.example.petclinic.bootstrap;

import com.example.petclinic.model.*;
import com.example.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader  implements CommandLineRunner {

    private  final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService){
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();

        if (count == 0)
           loadedData();

    }

    private void loadedData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);


        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        radiology.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        radiology.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);


        Owner owner1 = new Owner();
        owner1.setFirstName("Micheal");
        owner1.setLastName("Owen");
        owner1.setAddress("133- fake street");
        owner1.setCity("Lagos");
        owner1.setTelephone("123-423-332-323");



        Pet mikesPet = new Pet();
        mikesPet.setPetType(saveDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Jumbo");
        owner1.getPets().add(mikesPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Ferguson");
        owner2.setLastName("Alex");
        owner2.setAddress("133- fake street");
        owner2.setCity("Benin");
        owner2.setTelephone("123-532-332-323");



        Pet marysCat = new Pet();
        marysCat.setName("Cia");
        marysCat.setOwner(owner2);
        marysCat.setBirthDate(LocalDate.now());
        marysCat.setPetType(saveCatPetType);
        owner2.getPets().add(marysCat);
        ownerService.save(owner2);

        Visit catvist = new Visit();
        catvist.setPet(marysCat);
        catvist.setDescription("Sneezy kitty");
        catvist.setDate(LocalDate.now());
        visitService.save(catvist);

        System.out.println("loaded owners ....");

        Vet vet1 = new Vet();
        vet1.setFirstName("lsam");
        vet1.setLastName("Alex");
        vet1.getSpecialties().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Ejiro");
        vet2.setLastName("Pearson");
        vet2.getSpecialties().add(savedSurgery);
        vetService.save(vet2);

        System.out.println("loaded vets ....");
    }
}
