import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map, catchError } from 'rxjs/operators';
import { Result } from '../model/result';

/**
 * Service to convert a number
 */
@Injectable({
  providedIn: 'root'
})
export class FooBarQuixService {

  private API_SERVER = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  /**
   * Converts a number
   * @param inputNumber input number to convert
   */
  convertNumber(inputNumber: number): Observable<Result> {
    return this.http.get<Result>(this.API_SERVER + '/foo-bar-quix/' + inputNumber).pipe(
      map((response) => {
        return response;
      },
        catchError((err) => {
          console.error(err);
          throw err;
        }
        ))
    );
  }

}
