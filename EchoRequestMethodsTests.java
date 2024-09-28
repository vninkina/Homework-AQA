package Lesson17;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

// Задание Lesson17 тестирование папки Request Methods коллекции Postman Echo
public class EchoRequestMethodsTests {

    // baseURI хранится в переменной base
    String base = "https://postman-echo.com";

    // Метод GET
    @Test
    public void testGetRequest (){

        // Установка базового URI
        RestAssured.baseURI = base;

        // Запрос с параметрами
        given()
                .param("foo1", "bar1")
                .param("foo2", "bar2")

                // Указание типа запроса
                . when().get("/get")

                // Проверка и логирование ответа
                .then().log().body()

                // Проверка статуса ответа
                .statusCode(200)

                // Проверка полей ответа
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("headers.host", equalTo("postman-echo.com"))

                // Для полей, значения которых меняются при каждом запросе произведена проверка notNullValue
                .body("headers.x-request-start", notNullValue())
                .body("headers.connection", equalTo("close"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.accept", equalTo("*/*"))

                // Значение поля user-agent возвращает системную среду клиента, и может меняться
                .body("headers.user-agent", notNullValue())
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));
    }

    // Комментарии к строкам остальных тестов аналогичны комментариям первого теста.

    // Метод POST RawText
    @Test
    public void testPostRawTextRequest (){
        RestAssured.baseURI = base;
        given()
                .header("Content-Type", "text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .post("/post")
                .then().log().body()

                .statusCode (200)
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", notNullValue())
                .body("headers.connection", equalTo("close"))
                .body("headers.content-length", equalTo("58"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.accept", equalTo("*/*"))
                .body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"))
                .body("headers.user-agent", notNullValue())
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("json", nullValue())
                .body("url", equalTo("https://postman-echo.com/post"));
    }

    // Метод POST FormData
    @Test
    public void testPostFormDataRequest (){
        RestAssured.baseURI = base;
        given()
                .header("Content-Type", "text/plain")
                .param("foo1", "bar1")
                .param("foo2", "bar2")

                .when()
                .post("/post")
                .then().log().body()

                .statusCode (200)
                .body("data", equalTo("foo1=bar1&foo2=bar2"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", notNullValue())
                .body("headers.connection", equalTo("close"))
                .body("headers.content-length", equalTo("19"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.accept", equalTo("*/*"))
                .body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"))
                .body("headers.user-agent", notNullValue())
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("json", nullValue())
                .body("url", equalTo("https://postman-echo.com/post"));
    }

    // Метод PUT
    @Test
    public void testPutRequest (){
        RestAssured.baseURI = base;
        given()
                .header("Content-Type", "text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .put("/put")
                .then().log().body()

                .statusCode (200)
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", notNullValue())
                .body("headers.connection", equalTo("close"))
                .body("headers.content-length", equalTo("58"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.accept", equalTo("*/*"))
                .body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"))
                .body("headers.user-agent", notNullValue())
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("json", nullValue())
                .body("url", equalTo("https://postman-echo.com/put"));
    }

    // Метод PATCH
    @Test
    public void testPatchRequest (){
        RestAssured.baseURI = base;
        given()
                .header("Content-Type", "text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .patch("/patch")
                .then().log().body()

                .statusCode (200)
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", notNullValue())
                .body("headers.connection", equalTo("close"))
                .body("headers.content-length", equalTo("58"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.accept", equalTo("*/*"))
                .body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"))
                .body("headers.user-agent", notNullValue())
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("json", nullValue())
                .body("url", equalTo("https://postman-echo.com/patch"));
    }

    // Метод DELETE
    @Test
    public void testDeleteRequest (){
        RestAssured.baseURI = base;
        given()
                .header("Content-Type", "text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .delete("/delete")
                .then().log().body()

                .statusCode (200)
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", notNullValue())
                .body("headers.connection", equalTo("close"))
                .body("headers.content-length", equalTo("58"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.accept", equalTo("*/*"))
                .body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"))
                .body("headers.user-agent", notNullValue())
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("json", nullValue())
                .body("url", equalTo("https://postman-echo.com/delete"));
    }
}
