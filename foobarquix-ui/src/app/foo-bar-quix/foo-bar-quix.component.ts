import { Component } from '@angular/core';
import { FooBarQuixService } from '../services/foo-bar-quix.service';

/**
 * Component Foo Bar Quix
 */
@Component({
  selector: 'app-foo-bar-quix',
  templateUrl: './foo-bar-quix.component.html'
})
export class FooBarQuixComponent {

  /** List of results coming from the backend */
  results: NumberConverted[] = [];

  constructor(private fooBarQuixService: FooBarQuixService) { }

  /**
   * Function called when the form is submitted.
   * It calls the fooBarQuixService to convert a number.
   * @param inputNumber number to convert
   */
  convertNumber(inputNumber: number): void {
    this.fooBarQuixService.convertNumber(inputNumber).subscribe(
      response => this.results.push({numberToConvert: inputNumber, result: response.result}),
      error => console.error(error)
    );
  }

}

/** Interface used by the template to show the number converted */
interface NumberConverted {
  numberToConvert: number;
  result: string;
}
