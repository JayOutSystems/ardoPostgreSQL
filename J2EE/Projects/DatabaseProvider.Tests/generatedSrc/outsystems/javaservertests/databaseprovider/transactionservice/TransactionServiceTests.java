/* 
 This source code (the "Generated Software") is generated by the OutSystems Platform 
 and is licensed by OutSystems (http://www.outsystems.com) to You solely for testing and evaluation 
 purposes, unless You and OutSystems have executed a specific agreement covering the use terms and 
 conditions of the Generated Software, in which case such agreement shall apply. 
*/

package outsystems.javaservertests.databaseprovider.transactionservice;

import java.sql.*;
import java.text.*;
import java.util.*;
import org.junit.*;
import outsystems.hubedition.databaseabstractionlayer.adoadapters.*;
import outsystems.hubedition.extensibility.data.transactionservice.*;
import outsystems.hubedition.util.*;
import outsystems.hubedition.util.delegates.*;
import outsystems.servertests.databaseprovider.framework.*;
import java.math.BigDecimal;
import outsystems.hubedition.databaseabstractionlayer.adoadapters.ADOTransaction;
import outsystems.hubedition.extensibility.data.IDatabaseServices;
import outsystems.hubedition.extensibility.data.transactionservice.InvalidCommitOrRollbackTransactionException;
import outsystems.hubedition.extensibility.data.transactionservice.InvalidTransactionReleaseException;
import outsystems.hubedition.extensibility.data.transactionservice.ITransactionManager;
import outsystems.hubedition.extensibility.data.transactionservice.ITransactionService;
import outsystems.junit.framework.DashboardTestFixture;
import outsystems.junit.framework.IterativeTestCase;
import outsystems.junit.framework.JUnitTestAdapter;
import outsystems.junit.framework.TestDetails;
import outsystems.servertests.databaseprovider.framework.DashboardTest;
import outsystems.servertests.databaseprovider.framework.DatabaseProviderTest;
import outsystems.servertests.databaseprovider.framework.DatabaseProviderTestCase;
import outsystems.testscommon.AssertUtils;



@org.junit.runner.RunWith(outsystems.junit.logic.DashboardTestRunner.class)
@DashboardTestFixture(testKind=DashboardTest.DashboardTestKind)
public class TransactionServiceTests extends DatabaseProviderTest<TestConfiguration> {
    public static final TypeInformation<TransactionServiceTests> TypeInfo = TypeInformation.get(TransactionServiceTests.class);
    
    
    @outsystems.hubedition.util.obfuscation.DoNotRename
    private final void withTransactionManager(ITransactionManager tm, Action.Action1<ITransactionManager> action) {
        try {
            action.execute(tm);
        } finally{
            try {
                tm.freeupResources(false);
            }catch (Exception exceptionToHandle) {
            
        }
    }
    
}


@outsystems.hubedition.util.obfuscation.DoNotRename
private final void expectException(Class<?> exceptionType, Action.Action0 body) {
    
    boolean gotException = false;
    try {
        body.execute();
    }catch (Exception exceptionToHandle) {
        exceptionToHandle = WrappedException.unwrapExceptionIfNeeded(exceptionToHandle);
        
        {
            Exception e = (Exception)exceptionToHandle;
            gotException = e.getClass() == exceptionType;
        }
    }
    
    Assert.assertTrue("Should have thrown " + exceptionType.getSimpleName() + " exception", gotException);
}


@IterativeTestCase(iteratorType=TestConfiguration.class)

public final void getConsecutiveTransactionsWithRelease(DatabaseProviderTestCase tc) {
    IDatabaseServices services = tc.getServices();
    withTransactionManager(services.getTransactionService().createTransactionManager(), 
        new Action.Action1<ITransactionManager>() {
            protected void executeImpl(ITransactionManager tm) throws Exception
            {
                ADOTransaction trans1 = tm.getReadOnlyTransaction();
                tm.releaseTransaction(trans1);
                ADOTransaction trans2 = tm.getReadOnlyTransaction();
                Assert.assertEquals((Object) (trans1), (Object) (trans2));
            }
        });
}


@IterativeTestCase(iteratorType=TestConfiguration.class)

public final void getConsecutiveTransactionsUsingPrivate(DatabaseProviderTestCase tc) {
    IDatabaseServices services = tc.getServices();
    withTransactionManager(services.getTransactionService().createTransactionManager(), 
        new Action.Action1<ITransactionManager>() {
            protected void executeImpl(ITransactionManager tm) throws Exception
            {
                ADOTransaction trans1 = tm.getReadOnlyTransaction();
                tm.releaseTransaction(trans1);
                ADOTransaction trans2 = tm.getCommitableTransaction();
                JUnitTestAdapter.assertNotEquals("Transactions must be different", trans1, trans2);
            }
        });
}


@IterativeTestCase(iteratorType=TestConfiguration.class)

public final void getRequestTransaction(DatabaseProviderTestCase tc) {
    IDatabaseServices services = tc.getServices();
    withTransactionManager(services.getTransactionService().createTransactionManager(), 
        new Action.Action1<ITransactionManager>() {
            protected void executeImpl(ITransactionManager tm) throws Exception
            {
                ADOTransaction trans1 = tm.getRequestTransaction();
                ADOTransaction trans2 = tm.getRequestTransaction();
                Assert.assertEquals((Object) (trans1), (Object) (trans2));
            }
        });
}


@IterativeTestCase(iteratorType=TestConfiguration.class)

public final void privateTransactionNotReleasable(DatabaseProviderTestCase tc) {
    final RefParmHolder<IDatabaseServices> services = new RefParmHolder<IDatabaseServices>(tc.getServices());
    expectException(InvalidTransactionReleaseException.class, 
        new Action.Action0() {
            protected void executeImpl() throws Exception
            {
                withTransactionManager(services.getVal().getTransactionService().createTransactionManager(), 
                    new Action.Action1<ITransactionManager>() {
                        protected void executeImpl(ITransactionManager tm) throws Exception
                        {
                            ADOTransaction trans = tm.getCommitableTransaction();
                            tm.releaseTransaction(trans);
                        }
                    });
            }
        });
}


@IterativeTestCase(iteratorType=TestConfiguration.class)

public final void readOnlyTransactionNotCommitable(DatabaseProviderTestCase tc) {
    final RefParmHolder<IDatabaseServices> services = new RefParmHolder<IDatabaseServices>(tc.getServices());
    expectException(InvalidCommitOrRollbackTransactionException.class, 
        new Action.Action0() {
            protected void executeImpl() throws Exception
            {
                withTransactionManager(services.getVal().getTransactionService().createTransactionManager(), 
                    new Action.Action1<ITransactionManager>() {
                        protected void executeImpl(ITransactionManager tm) throws Exception
                        {
                            ADOTransaction trans = tm.getReadOnlyTransaction();
                            tm.commitTransaction(trans);
                        }
                    });
            }
        });
}


@IterativeTestCase(iteratorType=TestConfiguration.class)

public final void mainTransactionNotCommitable(DatabaseProviderTestCase tc) {
    final RefParmHolder<IDatabaseServices> services = new RefParmHolder<IDatabaseServices>(tc.getServices());
    expectException(InvalidCommitOrRollbackTransactionException.class, 
        new Action.Action0() {
            protected void executeImpl() throws Exception
            {
                withTransactionManager(services.getVal().getTransactionService().createTransactionManager(), 
                    new Action.Action1<ITransactionManager>() {
                        protected void executeImpl(ITransactionManager tm) throws Exception
                        {
                            ADOTransaction trans = tm.getRequestTransaction();
                            tm.commitTransaction(trans);
                        }
                    });
            }
        });
}

@IterativeTestCase(iteratorType=TestConfiguration.class)

public final void busyPrivateTransactionPoolCount(DatabaseProviderTestCase tc) {
    IDatabaseServices services = tc.getServices();
    withTransactionManager(services.getTransactionService().createTransactionManager(), 
        new Action.Action1<ITransactionManager>() {
            protected void executeImpl(ITransactionManager tm) throws Exception
            {
                int initialCount = tm.getBusyTransactionCount();
                ADOTransaction privateTrans1 = tm.getCommitableTransaction();
                Assert.assertTrue(tm.getBusyTransactionCount() == (initialCount + 1));
            }
        });
}


@IterativeTestCase(iteratorType=TestConfiguration.class)

public final void freeupResourcesClearsBusyTransactionPool(DatabaseProviderTestCase tc) {
    IDatabaseServices services = tc.getServices();
    withTransactionManager(services.getTransactionService().createTransactionManager(), 
        new Action.Action1<ITransactionManager>() {
            protected void executeImpl(ITransactionManager tm) throws Exception
            {
                ADOTransaction privateTrans1 = tm.getCommitableTransaction();
                ADOTransaction privateTrans2 = tm.getCommitableTransaction();
                tm.freeupResources(false);
                Assert.assertTrue(tm.getBusyTransactionCount() == 0);
            }
        });
}


public TransactionServiceTests() {
    super(TestConfiguration.TypeInfo);
}
}
