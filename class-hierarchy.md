classDiagram
    DatastoreWriter <|-- DatastoreBatchWriter
    DatastoreBatchWriter <|-- Transaction
    DatastoreReaderWriter<|-- Transaction
    DatastoreWriter <|-- DatastoreReaderWriter
    DatastoreReader <|-- DatastoreReaderWriter
    Transaction <|-- TransactionImpl
    BaseDatastoreBatchWriter <|-- TransactionImpl
    DatastoreBatchWriter <|-- BaseDatastoreBatchWriter
    DatastoreBatchWriter <|-- Batch
    BaseDatastoreBatchWriter <|-- BatchImpl
    Batch <|-- BatchImpl
    DatastoreReaderWriter <|-- Datastore
    Datastore <|-- DatastoreImpl
    
    class DatastoreWriter {
    }
    class DatastoreReader {
    }
    class Transaction{
    }
    class DatastoreBatchWriter{
    }
    class DatastoreReaderWriter {
    }
    class BaseDatastoreBatchWriter{
    }
    class TransactionImpl {
    }
    class Batch{
    }
    class BatchImpl{
    }
    class Datastore{
    }
    class DatastoreImpl{
    }

