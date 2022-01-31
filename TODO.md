- [ ] Pyet arin
    - [ ] Mund ta bejm kodin open source?
    - [ ] Mund te perdorim singletons?
    - [ ] Mund te perdorim font awesome?
    - [ ] Mund te perdorim hash maps?
    - [ ] Duhet ta ruajme inventarin ne binary file?

- [ ] App icon
- [ ] Rename the app to `FxStore`
- [ ] Replace lambdas with anonymous interfaces
- [ ] Store certain reusable colors somewhere
    - [ ] Background
    - [ ] The blue used
    - [ ] The error color
- [ ] Find a warmer error color
- [ ] Menu buttons
- [ ] Singletons should use the `self()` method because they need to implement the closable interface
- [ ] Visitor pattern for privileges handling
- [ ] (maybe) A Scene stack to handle the back button

- [ ] Folder structure
    - [ ] Users.ser
    - [ ] Stock.ser
    - [ ] bills
        - [ ] DD-MM-YYYY
            - [ ] <Cashier-X>.txt
                - [ ] <List-Of_Bills>.txt

- [ ] Employee format
    - [ ] Name
    - [ ] Surname
    - [ ] Password (only the employee can change it)
    - [ ] Role
        - Cashier
        - Manager
        - Admin
    - [ ] Birthday
    - [ ] Phone
    - [ ] Email
    - [ ] Salary


- [ ] Login
    - [ ] "Show Password" built into the Password field
     https://stackoverflow.com/a/67478991/9807802

- [ ] Nice to have
    - [ ] Show a character pressed on the password for half a second before hiding
    - [ ] Store the passwords as hashes for increased security


Done
===

- [x] Do you need the style class anymore?

- [ ] Login
    - [x] Users should login with name, surname + password
        (ie. no username)

- [ ] Widgets
    - [x] `FlatPasswordField`
        - [ ] Use custom skin  which stores a `censored` value to avoid having multiple widgets.