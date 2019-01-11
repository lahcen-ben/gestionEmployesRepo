import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http';
import { UploadFormComponent } from './upload-form/upload-form.component';
import {UploadFileService} from './service/upload-file.service';
import {EmployeService} from './service/employe.service';
import { EmployeListComponent } from './employe-list/employe-list.component';
import {FormsModule} from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    UploadFormComponent,
    EmployeListComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [UploadFileService, EmployeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
