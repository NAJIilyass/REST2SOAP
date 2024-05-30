# REST2SOAP

## Description
REST2SOAP is a project aimed at implementing a bridge to translate RESTful services to SOAP, facilitating interoperability between modern and legacy systems.

## Overview
In today's heterogeneous software landscape, interoperability between different types of services is crucial. While RESTful services are prevalent in modern web development, legacy systems often rely on SOAP-based services. REST2SOAP provides a solution to bridge this gap by enabling the translation of RESTful services to SOAP, allowing seamless communication between systems with different protocols.

## Features
- **Translation Bridge:** Convert RESTful services to SOAP, preserving functionality and data integrity;
- **Exception Handling:** Ensure proper handling and propagation of exceptions between REST and SOAP layers;
- **Troubleshooting:** Implement mechanisms for troubleshooting and traceability to aid in debugging and maintenance.

## Usage
To use REST2SOAP in your project, follow these steps:

1. **Clone the repository:**
   ```bash
   git clone https://github.com/NAJIilyass/REST2SOAP.git
   cd REST2SOAP
   ```

2. **Run the REST application:**
    - Navigate to the REST application main class and run it:
       ```bash
       REST/src/main/java/com/studentmanagment/DemoApplication.java
       ```

4. **Run the SOAP application:**
    - Navigate to the SOAP application main class and run it:
       ```bash
       SOAP/src/main/java/hh/ma/ac/inpt/server/ServicePublisher.java
       ```

5. Test the SOAP service:
   - Open an application like SOAP UI;
   - Use the WSDL URL to test requests:
      ```bash
      http://localhost:2020/webservices/ProductManager?wsdl
      ```

## Contact
For questions, feedback, or support, please contact us at najiilyassoo@gmail.com or ahmedelbaz771@gmail.com.

