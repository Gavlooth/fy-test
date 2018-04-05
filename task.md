
====================

Fy! Technical Task

Fy! is building an at-scale platform to combine millions of products from artists and brands within one addictive shopping experience. Brands work with Fy! on a dropship model, where they ship orders out directly from their own warehouse when a customer orders on the Fy! app.

As busy creative entrepreneurs, brands often need help to manage their business. You are designing a standalone Clojure system that suppliers can use to keep track of their stock, and to make sure that Fy! has an accurate view of what stock is available.


Using the system, brands should be able to:

    Log in with Google, Facebook or similar
    Record when they have received new stock for a product
    Record when they have shipped stock to a customer
    Record when they have received a return from a customer
    See the current available stock level for each product
    Be notified via email when they are out of stock of a product


The system should also notify Fy! programmatically whenever a stock level changes, identifying the product via a unique SKU code.


This exercise has 3 parts, and should take a maximum of 2 hours.

1. In an empty GitHub repository, outline your proposed solution in a file called `design.md`. Any images should also be in the repository.

Your solution should include:

    A short description of the solution
    A list of assumptions you’ve made
    Diagrams to explain your solution as you see necessary (e.g entity relationship, system context, architecture)
    Questions you have for us
    Considerations of how we would deploy, test and maintain your solution
    Considerations of how your solution would scale to millions of products and daily stock

2. In the same repository, create the folder structure and namespaces for how you might structure this solution in Clojure. You do *not* need to implement the solution, however feel free to use pseudo-code or namespace docstrings to explain your approach.

3. Create either a Leiningen `project.clj` or Boot `build.boot` that includes the dependencies that you would most likely use, based on your familiarity with the Clojure ecosystem.
