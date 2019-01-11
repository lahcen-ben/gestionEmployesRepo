import { Component, OnInit } from '@angular/core';
import {Employe} from '../model/Employe';
import {EmployeService} from '../service/employe.service';
import {Observable, of} from 'rxjs';
import {distinct, distinctUntilChanged, filter, map, switchMap} from 'rxjs/operators';

@Component({
  selector: 'employe-list',
  templateUrl: './employe-list.component.html',
  styleUrls: ['./employe-list.component.css']
})
export class EmployeListComponent implements OnInit {

  employes: Observable<Employe[]>;
  motCle: string = "";
  constructor(private employeService: EmployeService) {
  }

  ngOnInit() {
  }

  list() {
    this.employes = this.employeService.getEmployesList();
  }

  filterByNom(motCle: string) {
    this.employes.pipe(distinct((e: Employe)=>e.nom === motCle || e.prenom === motCle || e.profession === motCle))
      .subscribe(x=>console.log(x));
    //this.employes.pipe(distinctUntilChanged()).subscribe(x => console.log(x));
  }
}
