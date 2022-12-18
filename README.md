# brazilian-input-validator-library [![](https://jitpack.io/v/gustavodahora/brazilian-input-validator-library.svg)](https://jitpack.io/#gustavodahora/brazilian-input-validator-library)

A Validator for inputs from Brazil Official registers
At this moment, we finished the setup for a validation at CPF input on Brazil. You need to implement this project at readme.md to use all functions.

### Android Setup

Step 1. Add the JitPack repository to your build file. 
Add it in your root build.gradle at the end of repositories:

``` Gradle
allprojects {
  repositories {
    maven { url 'https://jitpack.io' }
  }
}
```

Step 2. Add the dependency

``` Gradle
dependencies {
  implementation 'com.github.gustavodahora:brazilian-input-validator-library:0.0.3'
}
```

-----

### How to use

You can use the ValidateInput class to find every validations available. So, we have initialy the validation for CPF. Below we have a exemple of use:

``` Kotlin
ValidateInput.cpf("757.697.100-20") // true
ValidateInput.cpf("111.111.111-11") // false
```

### Validations Available

`cpf`, `cnpj`

### Future Validations

`randomPix`, `email`, `phone`

-----

### License

Build in progress.
