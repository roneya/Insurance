**Insurance Project**
Here we have 15 + 2 Apis (these 2 apis basically links first one link user and insurnace polcies other one links insurance policy and claims). These linkings are done in one to many fashion in MySql.
The ClientUser model class represents a user of the insurance system, while the InsurancePolicy model class represents the policy that a user has purchased. The Claims model class represents claims made by users against their policies.<br>
My database:<br>
mysql> show tables;<br>
+----------------+<br>
| Tables_in_test |<br>
+----------------+<br>
| claims         |<br>
| clients        |<br>
| policies       |<br>
+----------------+<br>
Along with that mentioned 15 apis I have added mapping which is important to make this application more pratical with exception handling.
