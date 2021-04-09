package com.example.petclinic.bootstrap;

import com.example.petclinic.model.Owner;
import com.example.petclinic.model.Vet;
import com.example.petclinic.services.OwnerService;
import com.example.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader  implements CommandLineRunner {

    private  final OwnerService ownerService;
    private final VetService vetService;


    public DataLoader(OwnerService ownerService, VetService vetService){
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Micheal");
        owner1.setLastName("Owen");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Ferguson");
        owner2.setLastName("Alex");

        ownerService.save(owner2);

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
