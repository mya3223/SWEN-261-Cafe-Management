# SWEN-261-Cafe-Management

Cafe management project for SWEN 261 - Group 5

# Team Members

Meera Yousuf Alshara - 409004936

Syed Iftesam Hossain - 757000052

Mouza Alameri - 776006459

Francois Motte - 406007344

Ali Hamie - 757001996


# Product Vision

To upcoming entrepreneurs in the coffeeshop industry who require a cost-effective and effective means of running daily operations, our product is a cafe management system, which centralizes order tracking, inventory control, delivery management, and services to be offered. It further assists in decreasing operational complexity with the easy, convenient interface and equal commision system. Our solution is affordable, easy to use, and offers flexibility to new entrepreneurs unlike more complex or expensive enterprise systems; it includes the saved operational documentation, flexible pricing and three months of maintanance support based on their budget and stage of growth 

# Project Overview 

This project is being developed as a part of the SWEN 261 course at RIT Dubai, instructed by Professor Ali Assi.
The system allows for different types of users to interact with a cafe catalog, manage items, and process collections using a modern architecture

# Technology Stack

Backend: Java Spring Boot

Frontend: Mustache (HTML templates)

Database: None (ArrayList in-memory storage)

Project Management: Scrum with [Trello](https://trello.com/invite/b/696f297c36e70018d3f233b2/ATTI19dfb0717a7b2a0b1992adfc04f799e111786B2D/swen-261-cafe-management)

These can be found either through their links or through the Documentation Folder:

  [Functional Requirements Document](https://docs.google.com/document/d/1eMc52Au5xIlwfVMOMQQlgS9R2C_tn3YSlAWE2lU5fKE/edit?tab=t.0#heading=h.zdvtvb4foy3e)

  [Tracebility Matrix Spreadsheet](https://docs.google.com/spreadsheets/d/1XThwFhMMYKYLKBlE7lp5Z0-wSb4M6e3bc1sb83COF7k/edit?gid=0#gid=0)

  [Glossary of terms](https://docs.google.com/spreadsheets/d/1eluYVYd1kAN4puDzniHQ9QWfnva_sZ4aHyV88grYhw8/edit?gid=0#gid=0)

  [UML](https://lucid.app/lucidchart/55085f5a-c088-4a4d-9449-aad70fc40195/edit?invitationId=inv_d6bde052-db9e-4956-a122-efc43a3172a9)

# Sprint Plan (10 Days)

Days 1–2: Setup + task breakdown

Days 3–5: Backend development

Days 6–8: Frontend development

Days 9–10: Testing + integration + documentation

# Implemented User Stories (Assignment 2)

For Assignment 2, the following user stories were selected and distributed among the team:

US-001: Creation of Order

US-002: Viewing Orders

US-004: Viewing Pricing Packages

US-006: User Login and Session (Optional)

US-009: Order Search and Filter

# Work Distribution (Assignmnet 2)

Each team member contributed to both backend and frontend tasks as required:

Meera:
US-001 (Creation of Order) – Implemented backend (Order model, service, POST endpoint) and frontend (order creation form and integration)

Syed:
US-009 (Order Search and Filter) – Implemented backend (search and filter methods, endpoints) and frontend (search and filter interface)

Mouza:
US-002 (Viewing Orders) – Implemented backend (order retrieval logic) and frontend (display of active and completed orders)

Francois:
US-006 (User Login and Session – Optional) – Implemented backend (login logic) and frontend (login interface), and assisted in testing

Ali:
US-004 (Viewing Pricing Packages) – Implemented backend (pricing model and service) and frontend (pricing display page)
------------------------------------------------------------------------------------------------------------------------------------------
Meera:

US-003 (Tracking Order Status) - Implemented frontend and backend
US-012 (Low Stock Alerts) - Implemented frontend and backend

Syed:
US-005 (Selecting Pricing Packages) - Implemented frontend and backend

Francois:
US-007 (Role Based Access Control) - Implemented frontend and backend

Ali:
US-008 (Order Cancellation Before Preparation) - Implemented frontend and backend

Mouza:
US-011 (Inventory Item Management) - Implemented frontend and backend

# Implementation Details

Data is stored using ArrayList (in-memory storage) as required by the assignment

No database is used & data resets when the application restarts

Backend is implemented using Spring Boot with REST endpoints

Frontend is implemented using Mustache templates

Full integration between frontend and backend is achieved

# Key Features 
#Assignment 2
- Create and store new orders using a form
- Display active and completed orders
- Search and filter orders
- View pricing packages
- Basic login functionality (optional)

- #Assignment 3
- Full CRUD (Create, Read, Update, Delete) for all entities
- Simulated entity relationships using in-memory ArrayList storage
- REST API returning JSON responses
- Low stock alert system with dynamic inventory updates
- Order status tracking and cancellation
- Role-based access control (admin/staff)
- Feature branch Git workflow with pull requests
