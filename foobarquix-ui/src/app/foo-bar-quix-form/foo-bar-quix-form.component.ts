import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';

/**
 * Component for the convert number form
 */
@Component({
  selector: 'app-foo-bar-quix-form',
  templateUrl: './foo-bar-quix-form.component.html',
  styleUrls: ['./foo-bar-quix-form.component.css']
})
export class FooBarQuixFormComponent implements OnInit {

  /** The form */
  formGroup: FormGroup;

  /** Event sent to the parent component when the form is submitted */
  @Output()
  submitNumberOutput: EventEmitter<number> = new EventEmitter<number>();

  constructor(private readonly formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    // Creates the form
    this.formGroup = this.formBuilder.group({
      inputNumber: new FormControl('', Validators.required)
    });
  }

  /**
   * Function called when the form is submitted.
   * It sends the inputNumber from the form to the parent component.
   */
  submitNumber(): void {
    this.submitNumberOutput.emit(this.formGroup.get('inputNumber').value);
  }

}
