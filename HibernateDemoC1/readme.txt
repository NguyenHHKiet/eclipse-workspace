Exception in thread "main" java.lang.IllegalArgumentException: No query is registered under the name `Product.findAll`
	at org.hibernate.internal.AbstractSharedSessionContract.buildNamedQuery(AbstractSharedSessionContract.java:1002)
	at org.hibernate.internal.AbstractSharedSessionContract.createNamedQuery(AbstractSharedSessionContract.java:868)
	at org.hibernate.internal.AbstractSharedSessionContract.createNamedQuery(AbstractSharedSessionContract.java:123)
	at com.company.hibernate.Demo.main(Demo.java:19)
Caused by: org.hibernate.query.UnknownNamedQueryException: No query is registered under the name `Product.findAll`
	at org.hibernate.internal.AbstractSharedSessionContract.buildNamedQuery(AbstractSharedSessionContract.java:1041)
	at org.hibernate.internal.AbstractSharedSessionContract.buildNamedQuery(AbstractSharedSessionContract.java:965)
	... 3 more