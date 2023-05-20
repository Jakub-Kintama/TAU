describe('My First Test', () => {
  it('Visits the testes site', () => {
    cy.visit('https://opensource-demo.orangehrmlive.com/web/index.php/auth/login')
  })

  it('Invalid credential should be denied', () => {
    cy.visit('https://opensource-demo.orangehrmlive.com/web/index.php/auth/login')
    cy.get(':nth-child(2) > .oxd-input-group > :nth-child(2) > .oxd-input').type('user')
    cy.get(':nth-child(3) > .oxd-input-group > :nth-child(2) > .oxd-input').type('password')
    cy.get('.oxd-button').click()
    cy.wait(100)
    cy.get('.oxd-alert-content > .oxd-text').should('exist')
    cy.get('.oxd-userdropdown-tab').should('not.exist')
  })

  it('Valid credential should be allowed', () => {
    cy.visit('https://opensource-demo.orangehrmlive.com/web/index.php/auth/login')
    cy.get(':nth-child(2) > .oxd-input-group > :nth-child(2) > .oxd-input').type('Admin')
    cy.get(':nth-child(3) > .oxd-input-group > :nth-child(2) > .oxd-input').type('admin123')
    cy.get('.oxd-button').click()
    cy.get('.oxd-topbar-header-breadcrumb > .oxd-text').should('exist')
  })

  it('User has access to About informations', () => {
    cy.visit('https://opensource-demo.orangehrmlive.com/web/index.php/auth/login')
    cy.get(':nth-child(2) > .oxd-input-group > :nth-child(2) > .oxd-input').type('Admin')
    cy.get(':nth-child(3) > .oxd-input-group > :nth-child(2) > .oxd-input').type('admin123')
    cy.get('.oxd-button').click()
    cy.get('.oxd-userdropdown-tab').click()
    cy.get(':nth-child(1) > .oxd-userdropdown-link').click()
    cy.get('.orangehrm-modal-header > .oxd-text').should('exist')
  })

  it('User has access to Timesheet for Charlie Carter', () => {
    cy.visit('https://opensource-demo.orangehrmlive.com/web/index.php/auth/login')
    cy.get(':nth-child(2) > .oxd-input-group > :nth-child(2) > .oxd-input').type('Admin')
    cy.get(':nth-child(3) > .oxd-input-group > :nth-child(2) > .oxd-input').type('admin123')
    cy.get('.oxd-button').click()
    cy.get(':nth-child(4) > .oxd-main-menu-item').click()
    cy.get(':nth-child(5) > .oxd-table-row > [style="flex: 1 1 20%;"] > .oxd-table-cell-actions > .oxd-button').click()
    cy.get('.orangehrm-timesheet-header--title > .oxd-text').should('exist')
  })

  it('User is asked for credentials when accessing administrator tools', () => {
    cy.visit('https://opensource-demo.orangehrmlive.com/web/index.php/auth/login')
    cy.get(':nth-child(2) > .oxd-input-group > :nth-child(2) > .oxd-input').type('Admin')
    cy.get(':nth-child(3) > .oxd-input-group > :nth-child(2) > .oxd-input').type('admin123')
    cy.get('.oxd-button').click()
    cy.get(':nth-child(10) > .oxd-main-menu-item').click()
    cy.get(':nth-child(6) > .oxd-input-group > :nth-child(2) > .oxd-input').type('admin123')
    cy.get('.oxd-button--secondary').click()
    cy.get('.orangehrm-card-container > .oxd-text--h6').should('exist')
  })

})