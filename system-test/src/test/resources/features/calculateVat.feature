#language: en
#noinspection NonAsciiCharacters
Feature: VAT calculator

  As an API user, I would like to calculate Net, Gross, VAT amounts for purchases in Austria so
  that I can use correctly calculated purchase data.

  Scenario: Calculate VAT based on Net amount
    When I call the API with the Net amount and the VAT percentage
    Then I receive the result of the full calculation

  Scenario: Calculate VAT based on VAT amount
    When I call the API with the VAT amount and the VAT percentage
    Then I receive the result of the full calculation

  Scenario: Calculate VAT based on Gross amount
    When I call the API with the Gross amount and the VAT percentage
    Then I receive the result of the full calculation

  Scenario: Number format validation
    When I call the API with a text value instead of a number
    Then I receive the HAS_INVALID_VALUE error code

  Scenario: Validation for 0 value
    When I call the API with a 0 value
    Then I receive the HAS_INVALID_VALUE error code

  Scenario: Mandatory validation for VAT percentage
    When I call the API with an empty VAT percentage
    Then I receive the VAT_PERCENTAGE_IS_MANDATORY error code

  Scenario: Mandatory validation for amounts
    When I call the API without any amount
    Then I receive the ONE_OF_THE_AMOUNTS_IS_MANDATORY error code

  Scenario: More than one amount validation
    When I call the API with more than one amount
    Then I receive the MORE_THAN_ONE_AMOUNT_IS_GIVEN error code

  Scenario Outline: VAT based examples
    When I call the API with <vatAmount> VAT amount
    Then I receive the <grossAmount> Gross amount
    And I receive the <netAmount> Net amount
    Examples:
      | vatAmount | grossAmount | netAmount  |
      | 200       | 1200.00     | 1000.00    |
      | 125.23    | 751.38      | 626.15     |
      | 999999.99 | 5999999.94  | 4999999.95 |
      | 33.439    | 200.63      | 167.20     |
      | 33.438999 | 200.63      | 167.19     |
      | 33.438    | 200.63      | 167.19     |
      | 33.438999 | 200.63      | 167.19     |
      | 33.439166 | 200.63      | 167.20     |
      | 33.439167 | 200.64      | 167.20     |
      | 0.0009    | 0.01        | 0.00       |

  Scenario Outline: Gross based examples
    When I call the API with <grossAmount> Gross amount
    Then I receive the <vatAmount> VAT amount
    And I receive the <netAmount> Net amount
    Examples:
      | grossAmount | vatAmount    | netAmount    |
      | 1200        | 200.00       | 1000.00      |
      | 751.38      | 125.23       | 626.15       |
      | 5999999.9   | 999999.98    | 4999999.92   |
      | 123.233     | 20.54        | 102.69       |
      | 123.2339    | 20.54        | 102.69       |
      | 123.234     | 20.54        | 102.70       |
      | 123.249     | 20.54        | 102.71       |
      | 123.269     | 20.54        | 102.72       |
      | 123.27      | 20.55        | 102.73       |
      | 999999999   | 166666666.50 | 833333332.50 |

  Scenario Outline: Net based examples
    When I call the API with <netAmount> Net amount
    Then I receive the <vatAmount> VAT amount
    And I receive the <grossAmount> Gross amount
    Examples:
      | netAmount | vatAmount    | grossAmount   |
      | 1000      | 200.00       | 1200.00       |
      | 626.15    | 125.23       | 751.38        |
      | 4999999.9 | 999999.98    | 5999999.88    |
      | 1123.1041 | 224.62       | 1347.72       |
      | 1123.1042 | 224.62       | 1347.73       |
      | 1445.9249 | 289.18       | 1735.11       |
      | 1445.925  | 289.19       | 1735.11       |
      | 0.025     | 0.01         | 0.03          |
      | 999999999 | 199999999.80 | 1199999998.80 |
      | 12345.543 | 2469.11      | 14814.65      |