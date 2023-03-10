from selenium import webdriver
import logging
from selenium.webdriver.common.by import By


def basic_login():
    temp = driver.find_element(By.ID, 'user-name')
    temp.click()
    temp.send_keys("standard_user")

    temp = driver.find_element(By.ID, 'password')
    temp.click()
    temp.send_keys("secret_sauce")

    temp = driver.find_element(By.ID, 'login-button')
    temp.click()

    try:
        driver.find_element(By.ID, 'inventory_container')
        logger.info("Zalogowano pomyślnie")
    except:
        logger.error("Błąd logowania")


logger = logging.getLogger('Login testing lab02')
logger.setLevel(logging.INFO)
ch = logging.StreamHandler()
ch.setLevel(logging.DEBUG)
formatter = logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')
ch.setFormatter(formatter)
logger.addHandler(ch)

driver = webdriver.Chrome(executable_path="C:\\Users\\Kintama\\Downloads\\chromedriver_win32\\chromedriver.exe")

logger.info('Przechodzę na stronę SwagLabs')
driver.get('https://www.saucedemo.com')

logger.info("Testing basic login")
basic_login()

driver.close()