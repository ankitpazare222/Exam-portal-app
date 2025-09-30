import { inject } from '@angular/core';
import { CanActivateFn } from '@angular/router';
import { LoginuserService } from './loginuser.service';

export const adminGuard: CanActivateFn = (route, state) => {
  
  return true;
};
