from selenium import webdriver
import logging
import time
from selenium.webdriver.common.by import By


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

logger.info("Testing ended with " + str(counter) + " failed tests")

driver.close()