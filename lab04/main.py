from selenium import webdriver
import logging
import time
from selenium.webdriver.common.by import By


def load_page(page):
    driver.get(page)
    try:
        driver.find_element(By.ID, 'user-name')
        logger.info("Test successful")
        return 0
    except:
        logger.error("Test failed")
        return 1


def login(username, password):
    driver.get('https://www.saucedemo.com')
    temp = driver.find_element(By.ID, 'user-name')
    temp.click()
    temp.send_keys(username)

    temp = driver.find_element(By.ID, 'password')
    temp.click()
    temp.send_keys(password)

    driver.find_element(By.ID, 'login-button').click()


def basic_user():
    login("standard_user", "secret_sauce")
    try:
        driver.find_element(By.ID, 'inventory_container')
        logger.info("Test successful")
        return 0
    except:
        logger.error("Test failed")
        return 1


def locked_user():
    login("locked_out_user", "secret_sauce")
    try:
        driver.find_element(By.CLASS_NAME, 'error-message-container')
        logger.info("Test successful")
        return 0
    except:
        logger.error("Test failed")
        return 1


def problem_user():
    login("problem_user", "secret_sauce")
    try:
        driver.find_element(By.CLASS_NAME, 'inventory_container')
        logger.info("Test successful")
        return 0
    except:
        logger.error("Test failed")
        return 1


def glitch_user():
    start = time.time()
    login("performance_glitch_user", "secret_sauce")
    if time.time() - start > 3:
        logger.info("Test successful")
        return 0
    else:
        logger.error("Test failed")
        return 1


def empty_login():
    login("", "secret_sauce")
    try:
        driver.find_element(By.CLASS_NAME, 'error-message-container')
        logger.info("Test successful")
        return 0
    except:
        logger.error("Test failed")
        return 1


def empty_password():
    login("standard_user", "")
    try:
        driver.find_element(By.CLASS_NAME, 'error-message-container')
        logger.info("Test successful")
        return 0
    except:
        logger.error("Test failed")
        return 1


def wrong_login():
    login("somelogin", "secret_sauce")
    try:
        driver.find_element(By.CLASS_NAME, 'error-message-container')
        logger.info("Test successful")
        return 0
    except:
        logger.error("Test failed")
        return 1


def wrong_password():
    login("standard_user", "somepassword")
    try:
        driver.find_element(By.CLASS_NAME, 'error-message-container')
        logger.info("Test successful")
        return 0
    except:
        logger.error("Test failed")
        return 1


def logout():
    login("standard_user", "secret_sauce")
    driver.find_element(By.ID, 'react-burger-menu-btn').click()
    time.sleep(1)
    driver.find_element(By.ID, 'logout_sidebar_link').click()
    try:
        driver.find_element(By.CLASS_NAME, 'login_wrapper')
        logger.info("Test successful")
        return 0
    except:
        logger.error("Test failed")
        return 1


def add_item_to_cart(itemID):
    try:
        driver.find_element(By.ID, itemID).click()
        logger.info("Test successful")
        return 0
    except:
        logger.error("Test failed")
        return 1


def check_cart_badge_value(itemAmount):
    if len(driver.find_elements(By.CLASS_NAME, 'shopping_cart_badge')) != 0:
        if driver.find_element(By.CLASS_NAME, 'shopping_cart_badge').text == str(itemAmount):
            logger.info("Test successful")
            return 0
    else:
        if itemAmount == 0:
            logger.info("Test successful")
            return 0

    logger.error("Test failed")
    return 1


def scenario_1_load_page(counter):
    logger.info('Scenario 1: load page')

    logger.info("Testing if the page loaded")
    counter += load_page('https://www.saucedemo.com')

    logger.info("Scenario 1: ended with " + str(counter) + " failed tests")
    return counter


def scenario_2_login(counter):
    logger.info('Scenario 2: login')

    logger.info("Testing basic user login")
    counter += basic_user()

    logger.info("Testing locked user login")
    counter += locked_user()

    logger.info("Testing problem user login")
    counter += problem_user()

    logger.info("Testing glitch user login")
    counter += glitch_user()

    logger.info("Testing empty user login")
    counter += empty_login()

    logger.info("Testing empty user password")
    counter += empty_password()

    logger.info("Testing wrong user login")
    counter += wrong_login()

    logger.info("Testing wrong user password")
    counter += wrong_password()

    logger.info("Testing logout")
    counter += logout()

    logger.info("Scenario 2: ended with " + str(counter) + " failed tests")
    return counter


def scenario_3_cart(counter):
    logger.info('Scenario 3: cart')
    login("standard_user", "secret_sauce")

    logger.info("Testing if cart is empty")
    counter += check_cart_badge_value(0)

    logger.info("Testing adding item to cart")
    counter += add_item_to_cart('add-to-cart-sauce-labs-backpack')

    logger.info("Testing if cart updated")
    counter += check_cart_badge_value(1)

    logger.info("Scenario 3: ended with " + str(counter) + " failed tests")
    return counter


logger = logging.getLogger('Login testing lab02')
logger.setLevel(logging.INFO)
ch = logging.StreamHandler()
ch.setLevel(logging.DEBUG)
formatter = logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')
ch.setFormatter(formatter)
logger.addHandler(ch)

driver = webdriver.Chrome(executable_path="C:\\Users\\Kintama\\Downloads\\chromedriver_win32\\chromedriver.exe")
counter = 0

logger.info('Testing SwagLabs')

#counter += scenario_1_load_page(counter)
#counter += scenario_2_login(counter)
counter += scenario_3_cart(counter)

logger.info("Testing ended with total " + str(counter) + " failed tests")

driver.close()