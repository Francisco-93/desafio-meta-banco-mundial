import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FormViewComponent } from './form-view/form-view.component';
import { MainViewComponent } from './main-view/main-view.component';

const routes: Routes = [
  { path: '', component: MainViewComponent },
  { path: 'informations', component: FormViewComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
