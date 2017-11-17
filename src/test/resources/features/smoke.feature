Feature: Smoke Test Pack
    In order to check main functionality
    I want to do smoke test for sending an email

  @Positive
  @Smoke
  Scenario: 1 send an email
    Given on main page
    When enter "testforqualitytest@mail.ru" as login
    And enter "mailruforquality-lab" as password
    And click "Войти" button
    And create a new email
    And enter "testforqualitytest@mail.ru" in "Кому" field
    And enter "Test" in "Тема" field
    And enter "Some text in body" in "Body" field
    And click "Отправить" button
    Then an email was sent



   @CloseDriver
    Scenario: 5 Close Driver
      Given on main page
      Then close driver and browser
