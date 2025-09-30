// ✅ auth.interceptor.ts
import { inject } from '@angular/core';
import { HttpInterceptorFn } from '@angular/common/http';
import { LoginuserService } from './loginuser.service';

export const authInterceptorFn: HttpInterceptorFn = (req, next) => {
  const loginService = inject(LoginuserService);
  const token = loginService.gettoken();

  let authReq = req;
  if (token) {
    authReq = req.clone({
      setHeaders: {
        Authorization: `Bearer ${token}`,
      },
    });
  }

  return next(authReq);
};
