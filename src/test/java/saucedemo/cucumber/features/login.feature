Feature: Login page Aplikasi Sauce Demo

  @Regression @Positive
  Scenario: Success Login
    Given Halaman login Sauce Demo
    When  Input username
    And Input Password
    And Click login button
    Then User in on dashboard page

  @Regression @Negative
  Scenario: Failed Login
    Given Halaman login Sauce Demo
    When  Input username
    And Input Invalid Password
    And Click login button
    Then User get error message

  @Regression @AddProduct
  Scenario: Success Add Product
    Given Catalog Sauce Demo
    When User add product to cart
    Then Product added to cart