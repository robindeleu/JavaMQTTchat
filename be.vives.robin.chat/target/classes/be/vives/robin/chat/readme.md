```text
Bij de code staat er nog enkel maar het essentiele commentaar om het programma beter te kunnen begrijpen.

Functionaliteiten:
    - inloggen met verschillende namen inclusief met NULL omdat je zo "anoniem" kan chatten.
    - via enter of de knop graak je in het chatgedeelte 
    - dan vul je in op welk topic je wilt subcriben en publishen
    - je kan je bericht typen en op enter duwen om te versturen of de knop
    - op het scherm zal je centraal alle berichten kunnen ontvangen

Werkpunten
    - Publishen op een kanaal naar keuze lukt. Enkel subcriben op dat zelfde kanaal lukt nog niet. In de code staat deze fixed op Chat 1.
```
```java
    client.subscribe("test/oop2/chat/"+ subscribeTopic.getText(), new IMQTTMessageHandler(){ 
```
```text
    Dit gebruikte ik om te subcriben naar een channel naar keuze maar dit werkte niet. Heb nog enkele andere pogingen gedaan maar deze lukten tevergeefs niet.
```