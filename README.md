# brazilian-input-validator-library
A Validator for inputs from Brazil Official registers
At this moment, we finished the setup for a validation at CPF input on Brazil. You need to implement this project at readme.md to use all functions.

### Android Setup

Step 1. Add the JitPack repository to your build file

``` Gradle
allprojects {
  repositories {
    maven { url 'https://jitpack.io' }
  }
}
```

Add it in your root build.gradle at the end of repositories:


Step 2. Add the dependency

``` Gradle
dependencies {
  implementation 'com.github.gustavodahora:brazilian-input-validator-library:0.0.1'
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

`cpf`

### Future Validations

`cnpj`, `randomPix`

-----

### License

Build in progress.
