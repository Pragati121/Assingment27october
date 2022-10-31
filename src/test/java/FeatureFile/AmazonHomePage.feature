Feature:Add items to cart
  Scenario:Adding items to cart
    Given User is in the Home Page
    And   Go to search bar and search for mobiles
      |Samsung m32|
    And   Select one mobile and console its name
    And   Check and console size,color
    And   Go to customer question & answer section and print top three question and answers
    And   Add item to cart and also verify it in the cart
    When   Go to shopping cart and increase the quantity
    Then  Verify the item in the cart and console the total amount of product