**Mitä en testannut automaattisesti:**

- hahmojen liikkumiseen ja käyttäjän syötteisiin liittyviä metodeja ja muuttujia
- ikkunaan piirtämistä ja fps-laskuria
- kuvien lataamista

**Miten testasin näitä käsin:**

Käyttäjän syötteitä varten tulostin KeyManager-luokan keyPressed()-metodissa viestin "toimii", jolloin kun käyttäjä painoi nappia, 
tuli konsoliin kyseinen viesti.

Hahmojen järkevää ja oikeanlaista liikkumista testasin lähinnä pelaamalla itse peliä ja katsomalla, että hahmojen getInput()-metodin
ehtolauseet toteutuvat halutulla tavalla. Esimerkiksi, että hahmo ei voi hypätä jo ollessaan ilmassa tai, että hahmojen 
ylittäessä / alittaessa toisensa niiden sen hetkinen liikerata pysyy ennallaan, jolloin metodi isLeftmost() toimi halutulla tavalla. 

Hahmojen yhteentörmäyksiä testasin printtaamalla checkCollisions()- metodissa kumpaankiin ehtolauseeseen hahmon nimen, joka sai iskun perille.
Tästä huomasin, että aluksi vain ensimmäisen ehtolauseen pelaaja voitti, jos molemmat pelaajat potkaisivat samaan aikaan ja sen takia
lisäsinkin metodiin ehdon, jossa tarkistetaan kumpi hahmo oli korkeammalla.

Piirtämiseen ja päivittämiseen liittyviä metodeja tick() ja render() testasin myös pelaamalla peliä ja tarkistamalla että hahmot piirtyvät
sulavasti ruudulle ja päivittyvät oikein. Esimerkiksi kun käyttäjä painaa ENTER-painiketta pelin ollessa käynnissä hahmot palaavat
aloituspaikoilleen ja ne saavat täydet elämät. GameState-luokan drawWinner-metodin viestin ilmestymisen ja poistumisen testasin kokeilemalla
mitä tapahtuu, kun toinen pelaaja voittaa, peli aloitetaan alusta tai jos käyttäjä haluaa mennä takaisin päävalikkoon.

Game-luokassa sijaitsevassa run()-metodissa on myös fps-laskuri, joka pakottaa pelin pyörimään
tasaisesti 60 fps ja ja testasin tätä tulostamalla konsoliin ticks-muuttujan kutsumismäärän, jolloin konsoliin tulostuu "FPS: 60".

Kuvien lataamista testasin yksinkertaisesti suorittamalla ohjelmaa ja katsomalla, että halutut kuvat ilmestyvät ruudulle.

**Bugit:**

Mainittavin bugi ohjelmassa oli se, että joskus hyppypotkun jälkeen hahmo ei voinut hypätä taaksepäin maassa ollessaan. Sain tämän
korjattua, kun hieman hienosäädin maassa- ja ilmassaolemisen ehtoja.

