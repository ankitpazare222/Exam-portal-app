import { Routes } from '@angular/router';
// import { HomeComponent } from '../home/home.component';
import { AboutComponent } from '../about/about.component';
import { SingnupComponent } from './pages/singnup/singnup.component';
import { LoginComponent } from './pages/login/login.component';
import { HomeComponent } from './pages/home/home.component';
import { DashboardComponent } from './pages/admin/dashboard/dashboard.component';
import { UserdasboardComponent } from './pages/user/userdasboard/userdasboard.component';
// import { adminGuard } from './sevices/admin.guard';
import path from 'path';
import { ProfileComponent } from './pages/profile/profile.component';
import { AdminComponent } from './pages/admin/admin/admin.component';
// import { AdmindashboardComponent } from './pages/admin/admindashboard/admindashboard.component';
import { Component } from '@angular/core';

export const routes: Routes = [

 
    { path: 'about', component: AboutComponent },
    { path: 'singup', component: SingnupComponent },
    { path: 'login', component: LoginComponent },
    { path: '', component: HomeComponent },
    { path: 'admin', component: DashboardComponent,
        children:[{
            path:'porfile',
            component : AdminComponent,
        } 
        ]
    },
    { path: 'user', component: UserdasboardComponent },
    
];
