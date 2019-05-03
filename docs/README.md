# Game Squad
# Starbucks Application

**Chirag Arora**

**CMPE 202**

**Personal Project**

**San Jose State University**

Table of contents
=================

   * [Existing application](#existing-application)
   * [Use Case](#use-case)
   * [Design Notes](#design-notes)
      * [Composite](#composite)
      * [State](#state)
      * [Observer](#observer)
      * [Singleton](#singleton)
      * [Mixins](#mixins)
   * [Class Diagram](#class-diagram)
   * [Sequence Diagram](#sequence-diagram)
      * [Add Card Screen Sequence Diagram](#add-card-screen-sequence-diagram)
      * [Add Card Sequence Diagram](#add-card-sequence-diagram)
   * [Extra Credit](#extra-credit)
      * [Test Cases](#test-cases)
      * [Code Smells](#code-smells)
      * [First Ten](#first-ten)

This Mobile App Simulator Project is for Starbucks mobile app. The project is mainly implemented and designed keeping in mind different design patterns required for the class CMPE202.

The partial code was provided and the requirement of the project was to implement
  - Add New Card functionality
  - Complete the implementation of existing card
  - Provide use case and sequence diagrams of add new card functionality


## Existing application
The behaviour of existing application was kept in mind to design the new features, that is, without breaking existing test cases and functionality, implement new features. 

Existing application uses many different patterns already such as 
* Screen uses Composite pattern
* Keypad and PinEntryMachine share observer pattern
* PinEntryMachine uses state pattern to keep track of the pin states
* Stategy pattern is used to display the output in different format on the frame.

Before implementing new features, a bit of refactoring was done to bring down the code smells, such as
- implementing StaticTouchHandler interface as mixins to share the common behavior of multiple screens 
- implementing IScreenIterable to reduce the methods of Screen class [Shotgun surgery smell]
- implementing DigitsTracker to remove the responsiblity of PinEntryMachine [GodClass smell] 
================================

# Game Squad

Table of contents
=================

   * [UI Wireframes](#ui-wireframes)
   * [Use Case](#use-case)
   * [Class Diagram](#class-diagram)
   * [Activity Diagram](#activity-diagram)
   * [Design Patterns](#design-patterns)
      * [Decorator](#decorator)
      * [Strategy](#strategy)
      * [Factory](#factory)
      * [Composite](#composite)
      * [Observer](#observer)
      * [Feature 1](#feature-1)
      * [Feature 2](#feature-2)
      * [Feature 3](#feature-3)
      * [Feature 4](#feature-4)
      * [Feature 5](#feature-5)

## UI Wireframes
## Use Case
## Class Diagram
## Activity Diagram
## Design Patterns
##### Decorator
##### Strategy
##### Factory
##### Composite
##### Observer
##### Feature 1
##### Feature 2
##### Feature 3
##### Feature 4
##### Feature 5




