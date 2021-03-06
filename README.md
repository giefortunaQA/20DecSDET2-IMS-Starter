Coverage: 69.5% (Sonarqube)
## INVENTORY MANAGEMENT SYSTEM PROJECT

This application is created using Java and an embedded h2 database (MySQL). Running this program enables the user to perform tasks such as creating, reading, updating and deleting a record in the database.

## Getting Started

Firstly, make sure you have the following programs installed and ideally, Java and Maven are both added to your Path.

### Prerequisites

Git bash - to clone this repo <br />
Java 11 - to run the program <br />
Maven  - to run the unit tests <br />
MySQL

### Installing

Clone this repository to your local device. In Git bash:

```
git clone https://github.com/giefortunaQA/20DecSDET2-IMS-Starter.git
```

## Deployment

There is a "ims-0.0.1-jar-with-dependencies.jar" file which is executable from your command line. 
Before doing anything, make sure you have the right version of Java by running in your command line:
```
java -version
```

Then, change the directory to your local git repository and in the target directory:
```
cd ..\20DecSDET2-IMS-Starter\target
```

To start the application, execute the .jar file:
```
java -jar ims-0.0.1-jar-with-dependencies.jar
```

The above can also be ran without cloning the whole repository. Simply download the .jar file and run the same line, given you're in the directory where file is downloaded to.

Alternaltively, this package can be opened with Eclipse. Simply run the Runner.java file in src/main/java/com/qa/ims to start the application.

## Running the tests

To run the JUnit tests in this Maven package, simply change the directory to ..\20DecSDET2-IMS-Starter and execute
```
mvn test
```

### Unit Tests 

These tests confirm that each method returns the correct/expected value using assertions like assertEquals() statements. 

```
Example:
//Method in OrderDao
@Override
	public Order create(Order order) {
	    try (Connection connection = DatabaseUtilities.getInstance().getConnection();
                PreparedStatement statement = connection
                        .prepareStatement("INSERT INTO orders (fk_cid) VALUES (?);")){
            statement.setLong(1, order.getFkCid());
            statement.executeUpdate();
            return readLatest();
        } catch (Exception e) {
        	LOGGER.debug(e);
        	LOGGER.error(e.getMessage());
        }
        return null;
	}
//Test Method in OrderDaoTest
	@Test
	    public void testCreate() {
		 final Order order=new Order(2L, 1L,0.0);
		 assertEquals(order,DAO.create(order));
	    }
```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Hat tip to Nick and Pawel, our trainers
* Inspiration to my team, Team Serpent 
