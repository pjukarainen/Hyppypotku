**Aihe**: 2D-Taistelupeli nimeltä Hyppypotku. Pelissä on kaksi pelaajaa, jotka molemmat kontrolloivat yhtä hahmoa.
Pelin hahmot osaavat hyppiä ja potkia. Hyppy-nappi toimii aina samoin eli hahmo hyppää suoraan ylöspäin ruudulla.
Potku-napin toiminta taas riippuu siitä, onko hahmo jo ilmassa vai vielä maassa.
Kun potku-nappia painetaan ilmassa hahmo syöksyy maata kohti 45 asteen kulmassa liikkuen eteenpäin ja voi syöksyn aikana vahingoittaa vastustajaa.
Jos pelaaja painaa potku-nappia maassa ollessaan hahmo liikkuu taaksepäin.
Pelaaja joka onnistuneesti osuu yhden kerran hyppypotkulla vastustajaan voittaa kyseisen erän.
Pelin voittaa se pelaaja, joka voittaa ensin viisi erää.

**Käyttäjät** : Kaksi pelaajaa

**Käyttäjien toiminnot**:

- Ottelun käynnistäminen
- Hahmon kontrollointi

**Rakennekuvaus**: Ohjelman Assets-luokka valmistelee kaikki kuvat joita ohjelmassa tarvitsee. State-yliluokka määrittää sen periville luokille tick-, ja render-metodit. Menustate hoitaa päävalikon toiminnot ja Tutorialstate ohjeruudun näkymän. Gamestate renderöi pelattavat hahmot ja taustan ruudulle, sekä huolehtii ottelun voittajan julkistamisen, sekä hahmojen uudelleenasettamisen aloituspaikoilleen erän päätyttyä.

Blockman ja Stickman ovat pelin pelattavia hahmoja ja ne perivät Character-yliluokan, joka määrittää pelattaville hahmoille metodeja, jotka muun muassa auttavat saamaan selville onko hahmo ilmassa vai maassa. Character-luokka perii vielä Entity-luokan joka on kaikkien pelattavien objektien yliluokka. Window-luokka hoitaa ikkunan alustamisen. Game-luokka on ohjelman tärkein luokka, joka yhdistää kaikki edellämainitut luokat yhteen ja muodostaa niistä toimivan kokonaisuuden peliloopin avulla.

