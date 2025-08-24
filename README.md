# dummy-chargepoint

## 🔍 About

**dummy-chargepoint** is a command-line driven *Java* application to emulate a chargepoint using the 
[*OCPP* protocol](https://openchargealliance.org/).  
It started as a [school project](https://esipe.univ-gustave-eiffel.fr/formations/informatique-design-architecture-et-developpement-option-geomatique-logiciel-ou-reseau/last-project)
for a company. We've wanted to study and push this idea of an *API* which uses this protocol to configure multiple
chargepoints in real-time, and offer in the meantime, a user-friendly web application using the *API*.

**dummy-chargepoint** fits in our plan because it allows us to manually test the *OCPP* protocol.

## 📝 How to build

To build the application, follow these steps:

```shell
  # Clone the git repository
  git clone git@github.com:LastProject-ESIEE/dummy-chargepoint.git

  # Navigate to the project directory
  cd dummy-chargepoint
  
  # Check if everything is OK (test and compile)
  mvn clean verify
  
  # Package the project
  mvn package
```

## 🤝 Feedbacks and contributions

Even though we work hard on this project, there could be some bugs or improvements.  
However, you can contribute and help us implements improve this application.  
Please feel free to contribute by [submitting an issue](https://github.com/LastProject-ESIEE/dummy-chargepoint/issues).
Every contribution is welcome to make this project better every day !

## 📜 License

We strongly in open source, and we want to contribute as much as possible. That's why this project is licensed under a
[MIT license](LICENSE).



