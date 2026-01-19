# OrbitalStationEmergencySim

## Senaryo ozeti
Yorunge istasyonunda yasam destek, enerji ve haberlesme modulleri bulunur. Rastgele veya secilen siddette acil durumlar olusur; ekip uyeleri (muhendis, saglikci, pilot) duruma gore mudahale eder. Kaynaklar (enerji, oksijen, govde butunlugu) azalir ve onarim islemleriyle geri kazanilmaya calisilir.

## Sinif diyagrami benzeri aciklama
- app.Main: Menu ve giris noktasi.
- core.OrbitalStation: Istasyonun kaynaklari, moduller ve ekip listesini tutar.
- core.EmergencySimulator: Ekip mudahalesi ve onarim surecini yonetir.
- modules.Module: Tum moduller icin ust sinif.
- modules.LifeSupportModule, PowerModule, CommunicationModule: Module'dan turemis alt siniflar.
- crew.CrewMember: Tum ekip uyeleri icin ust sinif.
- crew.Engineer, Medic, Pilot: CrewMember'dan turemis alt siniflar.
- util.Severity: Acil durum siddetleri (LOW, MEDIUM, HIGH).
- util.InsufficientResourceException: Kaynak yetersizligi hatasi.

## OOP Ozellikleri (tanim + projede kullanimi)
1) class/object: Siniflardan new ile nesne uretip kullanma; `app/Main.java` icinde istasyon, moduller ve ekip nesneleri olusturulur.
2) inheritance: Bir sinifin baska bir siniftan miras almasi; `modules/Module.java` ust sinif ve `modules/LifeSupportModule.java` gibi alt siniflar ondan turemistir.
3) polymorphism: Ust sinif referansi ile alt sinif nesneleri calistirma; `core/OrbitalStation.java` icinde `List<Module>` uzerinde `handleEmergency` cagrilari yapilir.
4) overriding: Alt sinifin ust sinif metodunu farkli davranisla ezmesi; `modules/PowerModule.java` icinde `handleEmergency` metodu override edilir.
5) overloading: Ayni isimli metodun farkli parametrelerle tanimlanmasi; `core/OrbitalStation.java` icinde `triggerEmergency()` ve `triggerEmergency(Severity)` bulunur.
6) constructors: Nesne olusurken kullanilan yapicilar; `modules/Module.java` icinde parametresiz ve parametreli constructor vardir.
7) this: Nesnenin kendi alanlarini belirtmek icin kullanilir; `modules/Module.java` constructor icinde `this.name = name;` kullanilir.
8) final: Degistirilemez alan veya override edilemeyen metot; `modules/Module.java` icinde `id` alani `final` olarak tanimlidir.
9) access modifiers: Erisim duzeylerini belirler; `modules/Module.java` icinde `private`, `protected`, `public` alan ve metotlar vardir.

## Nasil calistirilir
1) VS Code icinde proje klasorunu acin.
2) Terminal:
```bash
javac -d out src/app/Main.java src/core/*.java src/modules/*.java src/crew/*.java src/util/*.java
java -cp out app.Main
```
