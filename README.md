# Google Form Automation Project

This project is designed to automate interactions with a Google Form, using **Java**, **Selenium**, and **TestNG** for testing purposes. The automation simulates a user interacting with the form, including filling out details, selecting options, calculating dates dynamically, and submitting the form. Upon successful submission, the automation verifies and captures the success message displayed on the form.

## Project Overview

The purpose of this project is to automate the following tasks on a Google Form:

1. **Navigating the Form**: The automation opens the Google Form and verifies that it loads correctly.
2. **Filling in Text Fields**: Dynamically inputs data into various text fields such as name, email, and any other required details.
3. **Selecting Options**:
   - **Radio Buttons**: Chooses appropriate options from radio buttons.
   - **Checkboxes**: Marks specific checkboxes based on predefined conditions.
   - **Dropdown Menus**: Selects values from dropdowns to simulate user input.
4. **Date Calculation**: Automatically calculates dates based on the current system date and inputs them into the form fields.
5. **Providing Time**: Inputs specific time values into the relevant form fields.
6. **Form Submission**: Submits the form and verifies the success message displayed upon completion.
7. **Validation**: Ensures that the success message is captured in the console, confirming a successful form submission.

## Tools and Technologies

- **Programming Language**: Java
- **Automation Framework**: Selenium WebDriver
- **Testing Framework**: TestNG
- **Build Tool**: Maven
- **Browser**: Google Chrome (via ChromeDriver)

## How to Run the Tests

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/ramzani77/Google_Form.git


