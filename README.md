My version of URL shortner using h2 DB using spring boot/JPA

The solution is incomplete.

But the logic/idea is as below.

1) User sends a request for the create short Url
2) API will receive long url, save the long urlin DB and generates a sequenceId
3) Convert the generated long sequence ID to short URL using Base 62 mechanism
4) And similarly while fetching the short url, user will send the shortUrl string
5) Short url string will be decoded to integer/long
6) The long is the sequenceId of the DB used to fetch the long url

`Base62` is the class which has encode and decode methods. But might need some refactoring.