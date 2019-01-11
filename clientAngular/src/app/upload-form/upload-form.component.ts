import {Component, OnInit} from '@angular/core';
import {UploadFileService} from '../service/upload-file.service';
import {HttpEventType, HttpResponse} from '@angular/common/http';

@Component({
  selector: 'upload-form',
  templateUrl: './upload-form.component.html',
  styleUrls: ['./upload-form.component.css']
})
export class UploadFormComponent implements OnInit {

  selectedFiles: FileList;
  currentFileUpload: File;
  progress: { percentage: number} = {percentage: 0};

  constructor(private uploadService: UploadFileService) { }

  ngOnInit() {
  }

  selectFile(event){
    this.selectedFiles = event.target.files;
  }

  uploadFile(){
    this.progress.percentage = 0;
    this.currentFileUpload = this.selectedFiles.item(0);
    this.uploadService.stockerFichier(this.currentFileUpload).subscribe(event => {
      if(event.type === HttpEventType.UploadProgress){
        this.progress.percentage = Math.round(100 * event.loaded / event.total);
      } else if(event instanceof HttpResponse){
        console.log('Fichier importé avec succès');
      }
    });

    this.selectedFiles = undefined;
  }

}
