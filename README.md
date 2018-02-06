# beer-service

# BeerRecom

BeerRecom API allow consumers to access a service which adapts the API from Recombee and use it to expose new method, which make an internal database interact with the external API.

## User


### List All Users [POST]

Return list of all users   

+ Request (text/xml)

        <soap:Envelope
            xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"
            soap:encodingStyle="http://www.w3.org/2001/12/soap-encoding">
            <soap:Body xmlns:m="http://soap.project.sde/">
                <m:readUserList>
                </m:readUserList>
            </soap:Body>
        </soap:Envelope>

+ Response 200 (text/xml)

    + Body

            <?xml version='1.0' encoding='UTF-8'?>
            <S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
                <S:Body>
                    <ns2:readUserListResponse xmlns:ns2="http://soap.project.sde/">
                        <user>
                            <username>user_1</username>
                            <password>1234</password>
                            <firstname>Marco</firstname>
                            <lastname>Rossi</lastname>
                            <email>aaa@bbb.c</email>
                        </user>
                        <user>
                            <username>user_2</username>
                            <password>1234</password>
                            <firstname>Mario</firstname>
                            <lastname>Verdi</lastname>
                            <email>aaaaa@mmmm.c</email>
                        </user>
                        <user>
                            <username>user_3</username>
                            <password>1234</password>
                            <firstname>Pablo</firstname>
                            <lastname>the Mexican</lastname>
                            <email>bababab@das.c</email>
                        </user>
                        <user>
                            <username>user_4</username>
                            <password>1234</password>
                            <firstname>Mister</firstname>
                            <lastname>Nobody</lastname>
                            <email>asda@asda.c</email>
                        </user>
                        <user>
                            <username>cane</username>
                            <password>cane</password>
                            <firstname></firstname>
                        </user>
                        <user>
                            <username>jave</username>
                            <password>ciao</password>
                        </user>
                    </ns2:readUserListResponse>
                </S:Body>
            </S:Envelope>
    
### Create a New User [POST]

Creates a new user, either in internal and external(Recombee) database.

+ Request (text/xml)

        <soap:Envelope
            xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"
            soap:encodingStyle="http://www.w3.org/2001/12/soap-encoding">
            <soap:Body xmlns:m="http://soap.project.sde/">
                <m:createUser>
                    <arg0>
                        <user>
                            <username>user_7</username>
                            <password>1234</password>
                            <firstname>Marco</firstname>
                            <lastname>Rossi</lastname>
                            <email>aaa@bbb.c</email>
                        </user>
                    </arg0>
                </m:createUser>
            </soap:Body>
        </soap:Envelope>

+ Response 201 (text/xml)

   
    + Body
    
        <?xml version='1.0' encoding='UTF-8'?>
            <S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
                <S:Body>
                    <ns2:createUser xmlns:ns2="http://soap.project.sde/">
                        <user>
                            <username>user_7</username>
                            <password>1234</password>
                            <firstname>Marco</firstname>
                            <lastname>Rossi</lastname>
                            <email>aaa@bbb.c</email>
                        </user>
                    </ns2:createUser>
                </S:Body>
            </S:Envelope>

### Get a User [POST]

Get a specific user from db.

+ Request (text/xml)

         <soap:Envelope
            xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"
            soap:encodingStyle="http://www.w3.org/2001/12/soap-encoding">
            <soap:Body xmlns:m="http://soap.project.sde/">
                <m:readUser>
                    <arg0>user_1</arg0>
                </m:readUser>
            </soap:Body>
        </soap:Envelope>

+ Response 201 (text/xml)

   
    + Body 
    
    <?xml version='1.0' encoding='UTF-8'?>
            <S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
                <S:Body>
                    <ns2:readUser xmlns:ns2="http://soap.project.sde/">
                        <user>
                            <username>user_1</username>
                            <password>1234</password>
                            <firstname>Marco</firstname>
                            <lastname>Rossi</lastname>
                            <email>aaa@bbb.c</email>
                        </user>
                    </ns2:readUser>
                </S:Body>
            </S:Envelope>

### Delete User [POST]

Delete user, either in internal and external(Recombee) database.


+ Request (text/xml)

        <soap:Envelope
            xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"
            soap:encodingStyle="http://www.w3.org/2001/12/soap-encoding">
            <soap:Body xmlns:m="http://soap.project.sde/">
                <m:deleteUser>
                    <arg0>
                      <user>
                            <username>user_7</username>
                            <password>1234</password>
                            <firstname>Marco</firstname>
                            <lastname>Rossi</lastname>
                            <email>aaa@bbb.c</email>
                        </user>
                    </arg0>
                </m:deleteUser>
            </soap:Body>
        </soap:Envelope>
        
+ Response 200 (text/xml)

        <?xml version='1.0' encoding='UTF-8'?>
            <S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
                <S:Body>
                    <ns2:deleteUser xmlns:ns2="http://soap.project.sde/">
                    <return>true</return>
                    </ns2:deleteUser>
                </S:Body>
            </S:Envelope>
   


## Beer

### List All Beers [POST]

Return list of all beers in db.

+ Request (text/xml)

        <soap:Envelope
            xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"
            soap:encodingStyle="http://www.w3.org/2001/12/soap-encoding">
            <soap:Body xmlns:m="http://soap.project.sde/">
                <m:readBeerList>
                </m:readBeerList>
            </soap:Body>
        </soap:Envelope>

+ Response 200 (text/xml)

    + Body

            <?xml version='1.0' encoding='UTF-8'?>
            <S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
            <S:Body>
                <ns2:readBeerListResponse xmlns:ns2="http://soap.project.sde/">
                    <beer>
                        <color>Chiara</color>
                        <taste>Dolce</taste>
                        <idBeer>1</idBeer>
                        <name>Surama</name>
                        <type>Saison</type>
                    </beer>
                    <beer>
                        <color>Ambrata</color>
                        <taste>Amara</taste>
                        <idBeer>2</idBeer>
                        <name>Obice</name>
                        <type>Pale Ale</type>
                    </beer>
                    <beer>
                        <color>Ambrata</color>
                        <taste>Amara</taste>
                        <idBeer>3</idBeer>
                        <name>Bibock</name>
                        <type>Pils</type>
                    </beer>
                    <beer>
                        <color>Chiara</color>
                        <taste>Dolce</taste>
                        <idBeer>4</idBeer>
                        <name>Cangrande</name>
                        <type>Helles</type>
                    </beer>
                    <beer>
                        <color>Chiara</color>
                        <taste>Amara</taste>
                        <idBeer>5</idBeer>
                        <name>Whale</name>
                        <type>Blanche</type>
                    </beer>
                    <beer>
                        <color>Scura</color>
                        <taste>Amara</taste>
                        <idBeer>6</idBeer>
                        <name>Boogeyman</name>
                        <type>Porter</type>
                    </beer>
                    <beer>
                        <color>Scura</color>
                        <taste>Dolce</taste>
                        <idBeer>7</idBeer>
                        <name>Fear</name>
                        <type>Stout</type>
                    </beer>
                    <beer>
                        <color>Chiara</color>
                        <taste>Dolce</taste>
                        <idBeer>8</idBeer>
                        <name>Weissbear</name>
                        <type>Weizen</type>
                    </beer>
                    <beer>
                        <color>Ambrata</color>
                        <taste>Dolce</taste>
                        <idBeer>9</idBeer>
                        <name>Foxtail</name>
                        <type>Ale</type>
                    </beer>
                    <beer>
                        <color>Chiara</color>
                        <taste>Dolce</taste>
                        <idBeer>10</idBeer>
                        <name>Stoner</name>
                        <type>Tripel</type>
                    </beer>
                    <beer>
                        <color>Ambrata</color>
                        <taste>Amara</taste>
                        <idBeer>11</idBeer>
                        <name>Acerbus</name>
                        <type>Bitter</type>
                    </beer>
                    <beer>
                        <color>Chiara</color>
                        <taste>Acida</taste>
                        <idBeer>12</idBeer>
                        <name>Dr.Caligari</name>
                        <type>Pale Ale</type>
                    </beer>
                    <beer>
                        <color>Chiara</color>
                        <taste>Acida</taste>
                        <idBeer>13</idBeer>
                        <name>Seta Special</name>
                        <type>Blanche</type>
                    </beer>
                    <beer>
                        <color>Scura</color>
                        <taste>Amara</taste>
                        <idBeer>14</idBeer>
                        <name>Madida</name>
                        <type>Porter</type>
                    </beer>
                    <beer>
                        <color>Scura</color>
                        <taste>Amara</taste>
                        <idBeer>15</idBeer>
                        <name>Cabossa</name>
                        <type>Stout</type>
                    </beer>
                    <beer>
                        <color>Scura</color>
                        <taste>Amara</taste>
                        <idBeer>16</idBeer>
                        <name>China</name>
                        <type>Porter</type>
                    </beer>
                    <beer>
                        <color>Chiara</color>
                        <taste>Dolce</taste>
                        <idBeer>17</idBeer>
                        <name>Rebhell</name>
                        <type>Pils</type>
                    </beer>
                    <beer>
                        <color>Scura</color>
                        <taste>Dolce</taste>
                        <idBeer>18</idBeer>
                        <name>Vudu</name>
                        <type>Weizen</type>
                    </beer>
                    <beer>
                        <color>Chiara</color>
                        <taste>Dolce</taste>
                        <idBeer>19</idBeer>
                        <name>Rat Weizen</name>
                        <type>Weizen</type>
                    </beer>
                    <beer>
                        <color>Chiara</color>
                        <taste>Dolce</taste>
                        <idBeer>20</idBeer>
                        <name>Farrotta</name>
                        <type>Pale Ale</type>
                    </beer>
                </ns2:readBeerListResponse>
            </S:Body>
        </S:Envelope>

### Create a New Beer [POST]

Creates a new user, either in internal and external(Recombee) database.

+ Request (text/xml)

        <soap:Envelope
            xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"
            soap:encodingStyle="http://www.w3.org/2001/12/soap-encoding">
            <soap:Body xmlns:m="http://soap.project.sde/">
                <m:createBeer>
                    <arg0>
                        <beer>
                            <color>Chiara</color>
                            <taste>Dolce</taste>
                            <idBeer>20</idBeer>
                            <name>Farrotta</name>
                            <type>Pale Ale</type>
                        </beer>
                    </arg0>
                </m:createUser>
            </soap:Body>
        </soap:Envelope>

+ Response 201 (text/xml)

   
    + Body
    
    
            <?xml version='1.0' encoding='UTF-8'?>
                <S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
                    <S:Body>
                        <ns2:createUser xmlns:ns2="http://soap.project.sde/">
                            <beer>
                                <color>Chiara</color>
                                <taste>Dolce</taste>
                                <idBeer>20</idBeer>
                                <name>Farrotta</name>
                                <type>Pale Ale</type>
                            </beer>
                        </ns2:createUser>
                    </S:Body>
                </S:Envelope>

### Get a User [POST]

Get a specific beer from db. 
 
+ Request (text/xml)

         <soap:Envelope
            xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"
            soap:encodingStyle="http://www.w3.org/2001/12/soap-encoding">
            <soap:Body xmlns:m="http://soap.project.sde/">
                <m:readBeer>
                    <arg0>1</arg0>
                </m:readUser>
            </soap:Body>
        </soap:Envelope>

+ Response 201 (text/xml)

   
    + Body
    <?xml version='1.0' encoding='UTF-8'?>
            <S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
                <S:Body>
                    <ns2:readBeer xmlns:ns2="http://soap.project.sde/">
                        <beer>
                            <color>Chiara</color>
                            <taste>Dolce</taste>
                            <idBeer>1</idBeer>
                            <name>Surama</name>
                            <type>Saison</type>
                        </beer>
                    </ns2:readBeer>
                </S:Body>
            </S:Envelope>

### Delete User [POST]

Delete beer, either in internal and external(Recombee) database.
   
+ Request (text/xml)

        <soap:Envelope
            xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"
            soap:encodingStyle="http://www.w3.org/2001/12/soap-encoding">
            <soap:Body xmlns:m="http://soap.project.sde/">
                <m:deleteBeer>
                    <arg0>
                        <beer>
                            <color>Chiara</color>
                            <taste>Dolce</taste>
                            <idBeer>20</idBeer>
                            <name>Farrotta</name>
                            <type>Pale Ale</type>
                        </beer>
                    </arg0>
                </m:deleteUser>
            </soap:Body>
        </soap:Envelope>

+ Response 200 (text/xml)

    + Body

<?xml version='1.0' encoding='UTF-8'?>
            <S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
                <S:Body>
                    <ns2:deleteBeer xmlns:ns2="http://soap.project.sde/">
                    <return>true</return>
                    </ns2:deleteBeer>
                </S:Body>
            </S:Envelope>
   
   

## User-Beer Interaction

### Rating

#### Add Rating [POST] 

Add a rating from a specific user to a beer.

+ Request (text/xml) 

        <soap:Envelope
                xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"
                soap:encodingStyle="http://www.w3.org/2001/12/soap-encoding">
                <soap:Body xmlns:m="http://soap.project.sde/">
                    <m:rateUserBeer>
                        <arg0>
                             <user>
                                <username>user_1</username>
                                <password>1234</password>
                                <firstname>Marco</firstname>
                                <lastname>Rossi</lastname>
                                <email>aaa@bbb.c</email>
                            </user>
                        </arg0>
                        <arg1>
                            <beer>
                                <color>Chiara</color>
                                <taste>Dolce</taste>
                                <idBeer>20</idBeer>
                                <name>Farrotta</name>
                                <type>Pale Ale</type>
                            </beer>
                        </arg1>
                        <arg2>4</arg2>
                    </m:rateUserBeer>
                </soap:Body>
            </soap:Envelope>


+ Response 200 (text/xml)

   + Body
   
        <?xml version='1.0' encoding='UTF-8'?>
            <S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
                <S:Body>
                    <ns2:rateUserBeer xmlns:ns2="http://soap.project.sde/">
                    <return>true</return>
                    </ns2:rateUserBeer>
                </S:Body>
            </S:Envelope>
            

#### Get Rating [POST]

Return the rating given by a specific user to a beer.

+ Request (text/xml)
 
    
        <soap:Envelope
                xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"
                soap:encodingStyle="http://www.w3.org/2001/12/soap-encoding">
                <soap:Body xmlns:m="http://soap.project.sde/">
                    <m:getBeerRatingUser>
                        <arg0>
                             <user>
                                <username>user_1</username>
                                <password>1234</password>
                                <firstname>Marco</firstname>
                                <lastname>Rossi</lastname>
                                <email>aaa@bbb.c</email>
                            </user>
                        </arg0>
                        <arg1>
                            <beer>
                               <color>Chiara</color>
                                <taste>Dolce</taste>
                                <idBeer>1</idBeer>
                                <name>Surama</name>
                                <type>Saison</type>   
                            </beer>
                        </arg1>
                        <arg2>4</arg2>
                    </m:getBeerRatingUser>
                </soap:Body>
            </soap:Envelope>

+ Response 200 (text/xml)

   + Body
   
      <?xml version='1.0' encoding='UTF-8'?>
            <S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
                <S:Body>
                    <ns2:getBeerRatingUser xmlns:ns2="http://soap.project.sde/">
                    <return>3.0</return>
                    </ns2:getBeerRatingUser>
                </S:Body>
            </S:Envelope>

### View

#### Add View [POST]

Add a view(producted been viewed) from a specific user to beer.

+ Request (text/xml)

        <soap:Envelope
                xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"
                soap:encodingStyle="http://www.w3.org/2001/12/soap-encoding">
                <soap:Body xmlns:m="http://soap.project.sde/">
                    <m:addUserView>
                        <arg0>
                             <user>
                                <username>user_1</username>
                                <password>1234</password>
                                <firstname>Marco</firstname>
                                <lastname>Rossi</lastname>
                                <email>aaa@bbb.c</email>
                            </user>
                        </arg0>
                        <arg1>
                            <beer>
                               <color>Chiara</color>
                                <taste>Dolce</taste>
                                <idBeer>1</idBeer>
                                <name>Surama</name>
                                <type>Saison</type>   
                            </beer>
                        </arg1>
                    </m:addUserView>
                </soap:Body>
            </soap:Envelope>

+ Response 200 (text/xml)

   + Body
    
    <?xml version='1.0' encoding='UTF-8'?>
            <S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
                <S:Body>
                    <ns2:addUserView xmlns:ns2="http://soap.project.sde/">
                    <return>true</return>
                    </ns2:addUserView>
                </S:Body>
            </S:Envelope>


### Wishlist

#### Get Wishlist [POST]

Return the wishlist of beers fro a user.

+ Request (text/xml)

        <soap:Envelope
                xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"
                soap:encodingStyle="http://www.w3.org/2001/12/soap-encoding">
                <soap:Body xmlns:m="http://soap.project.sde/">
                    <m:readUserWL>
                        <arg0>
                             <user>
                                <username>user_1</username>
                                <password>1234</password>
                                <firstname>Marco</firstname>
                                <lastname>Rossi</lastname>
                                <email>aaa@bbb.c</email>
                            </user>
                        </arg0>
                    </m:readUserWL>
                </soap:Body>
            </soap:Envelope>

+ Response 200 (text/xml)

   + Body
   
   
            <?xml version='1.0' encoding='UTF-8'?>
                <S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
                    <S:Body>
                        <ns2:readUserWL xmlns:ns2="http://soap.project.sde/">
                            <beer>
                                <color>Chiara</color>
                                <taste>Dolce</taste>
                                <idBeer>20</idBeer>
                                <name>Farrotta</name>
                                <type>Pale Ale</type>
                            </beer>
                            <beer>
                                <color>Ambrata</color>
                                <taste>Amara</taste>
                                <idBeer>11</idBeer>
                                <name>Acerbus</name>
                                <type>Bitter</type>
                            </beer>
                            <beer>
                                <color>Scura</color>
                                <taste>Dolce</taste>
                                <idBeer>18</idBeer>
                                <name>Vudu</name>
                                <type>Weizen</type>
                            </beer>
                        </ns2:readUserWL>
                    </S:Body>
                </S:Envelope>

#### Add to Wishlist [POST]

Add a beer to the wishlist of a user.

+ Request (text/xml)

        <soap:Envelope
                xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"
                soap:encodingStyle="http://www.w3.org/2001/12/soap-encoding">
                <soap:Body xmlns:m="http://soap.project.sde/">
                    <m:addBeerToUser>
                        <arg0>
                             <user>
                                <username>user_1</username>
                                <password>1234</password>
                                <firstname>Marco</firstname>
                                <lastname>Rossi</lastname>
                                <email>aaa@bbb.c</email>
                            </user>
                        </arg0>
                        <arg1>
                            <beer>
                               <color>Chiara</color>
                                <taste>Dolce</taste>
                                <idBeer>1</idBeer>
                                <name>Surama</name>
                                <type>Saison</type>   
                            </beer>
                        </arg1>
                    </m:addBeerToUser>
                </soap:Body>
            </soap:Envelope>

+ Response 200 (text/xml)

   + Body
        
        <?xml version='1.0' encoding='UTF-8'?>
            <S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
                <S:Body>
                    <ns2:addBeerToUser xmlns:ns2="http://soap.project.sde/">
                    <return>0</return>
                    </ns2:addBeerToUser>
                </S:Body>
            </S:Envelope>

#### Remove from Wishlist [POST]

Removes a beer from the wishlist of a user.

+ Request (text/xml)

        <soap:Envelope
                xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"
                soap:encodingStyle="http://www.w3.org/2001/12/soap-encoding">
                <soap:Body xmlns:m="http://soap.project.sde/">
                    <m:removeBeerToUser>
                        <arg0>
                             <user>
                                <username>user_1</username>
                                <password>1234</password>
                                <firstname>Marco</firstname>
                                <lastname>Rossi</lastname>
                                <email>aaa@bbb.c</email>
                            </user>
                        </arg0>
                        <arg1>
                            <beer>
                               <color>Chiara</color>
                                <taste>Dolce</taste>
                                <idBeer>1</idBeer>
                                <name>Surama</name>
                                <type>Saison</type>   
                            </beer>
                        </arg1>
                    </m:removeBeerToUser>
                </soap:Body>
            </soap:Envelope>

+ Response 200 (text/xml)

   + Body
        
        <?xml version='1.0' encoding='UTF-8'?>
            <S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
                <S:Body>
                    <ns2:removeBeerToUser xmlns:ns2="http://soap.project.sde/">
                    <return>0</return>
                    </ns2:removeBeerToUser>
                </S:Body>
            </S:Envelope>


## Recommendation

### Get Beer Recommendation [POST]

Return a specific number of recommendations for a user.

+ Request (text/xml)

        <soap:Envelope
                xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"
                soap:encodingStyle="http://www.w3.org/2001/12/soap-encoding">
                <soap:Body xmlns:m="http://soap.project.sde/">
                    <m:getUserRecom>
                        <arg0>
                             <user>
                                <username>user_1</username>
                                <password>1234</password>
                                <firstname>Marco</firstname>
                                <lastname>Rossi</lastname>
                                <email>aaa@bbb.c</email>
                            </user>
                        </arg0> 
                        <arg1>2</arg1>
                    </m:getUserRecom>
                </soap:Body>
            </soap:Envelope>

+ Response 200 (text/xml)

   + Body 
   
        <?xml version='1.0' encoding='UTF-8'?>
                <S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
                    <S:Body>
                        <ns2:getUserRecom xmlns:ns2="http://soap.project.sde/">
                            <beer>
                                <color>Chiara</color>
                                <taste>Dolce</taste>
                                <idBeer>20</idBeer>
                                <name>Farrotta</name>
                                <type>Pale Ale</type>
                            </beer>
                            <beer>
                                <color>Ambrata</color>
                                <taste>Amara</taste>
                                <idBeer>11</idBeer>
                                <name>Acerbus</name>
                                <type>Bitter</type>
                            </beer>
                        </ns2:getUserRecom>
                    </S:Body>
                </S:Envelope>





beerecom.docs.apiary.io
