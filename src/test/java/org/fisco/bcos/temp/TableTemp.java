package org.fisco.bcos.temp;

import io.reactivex.Flowable;
import org.fisco.bcos.channel.client.TransactionSucCallback;
import org.fisco.bcos.web3j.abi.EventEncoder;
import org.fisco.bcos.web3j.abi.TypeReference;
import org.fisco.bcos.web3j.abi.datatypes.DynamicArray;
import org.fisco.bcos.web3j.abi.datatypes.Event;
import org.fisco.bcos.web3j.abi.datatypes.Function;
import org.fisco.bcos.web3j.abi.datatypes.Type;
import org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32;
import org.fisco.bcos.web3j.abi.datatypes.generated.Int256;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.DefaultBlockParameter;
import org.fisco.bcos.web3j.protocol.core.RemoteCall;
import org.fisco.bcos.web3j.protocol.core.methods.request.BcosFilter;
import org.fisco.bcos.web3j.protocol.core.methods.response.Log;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tuples.generated.Tuple3;
import org.fisco.bcos.web3j.tx.Contract;
import org.fisco.bcos.web3j.tx.TransactionManager;
import org.fisco.bcos.web3j.tx.gas.ContractGasProvider;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.fisco.bcos.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version none.
 */
@SuppressWarnings("unchecked")
public class TableTemp extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50612648806100206000396000f30060806040526004361061006d576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680635322806314610072578063c4f41ab314610185578063db842ce71461020c578063efc81a8c1461031f578063fcd7e3c11461034a575b600080fd5b34801561007e57600080fd5b5061016f600480360381019080803590602001908201803590602001908080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050919291929080359060200190929190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050610498565b6040518082815260200191505060405180910390f35b34801561019157600080fd5b506101f6600480360381019080803590602001908201803590602001908080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050919291929080359060200190929190505050610bdd565b6040518082815260200191505060405180910390f35b34801561021857600080fd5b50610309600480360381019080803590602001908201803590602001908080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050919291929080359060200190929190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803590602001908201803590602001908080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505091929192905050506110d6565b6040518082815260200191505060405180910390f35b34801561032b57600080fd5b506103346118f2565b6040518082815260200191505060405180910390f35b34801561035657600080fd5b506103b1600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050611a8a565b60405180806020018060200180602001848103845287818151815260200191508051906020019060200280838360005b838110156103fc5780820151818401526020810190506103e1565b50505050905001848103835286818151815260200191508051906020019060200280838360005b8381101561043e578082015181840152602081019050610423565b50505050905001848103825285818151815260200191508051906020019060200280838360005b83811015610480578082015181840152602081019050610465565b50505050905001965050505050505060405180910390f35b600080600080600061100193508373ffffffffffffffffffffffffffffffffffffffff1663f23f63c96040518163ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180806020018281038252600b8152602001807f745f5461626c6554656d70000000000000000000000000000000000000000000815250602001915050602060405180830381600087803b15801561054557600080fd5b505af1158015610559573d6000803e3d6000fd5b505050506040513d602081101561056f57600080fd5b810190808051906020019092919050505092508273ffffffffffffffffffffffffffffffffffffffff166313db93466040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b1580156105e657600080fd5b505af11580156105fa573d6000803e3d6000fd5b505050506040513d602081101561061057600080fd5b810190808051906020019092919050505091508173ffffffffffffffffffffffffffffffffffffffff1663e942b5168a6040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808060200180602001838103835260048152602001807f6e616d6500000000000000000000000000000000000000000000000000000000815250602001838103825284818151815260200191508051906020019080838360005b838110156106e35780820151818401526020810190506106c8565b50505050905090810190601f1680156107105780820380516001836020036101000a031916815260200191505b509350505050600060405180830381600087803b15801561073057600080fd5b505af1158015610744573d6000803e3d6000fd5b505050508173ffffffffffffffffffffffffffffffffffffffff16632ef8ba74896040518263ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018080602001838152602001828103825260078152602001807f6974656d5f69640000000000000000000000000000000000000000000000000081525060200192505050600060405180830381600087803b1580156107f057600080fd5b505af1158015610804573d6000803e3d6000fd5b505050508173ffffffffffffffffffffffffffffffffffffffff1663e942b516886040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808060200180602001838103835260098152602001807f6974656d5f6e616d650000000000000000000000000000000000000000000000815250602001838103825284818151815260200191508051906020019080838360005b838110156108c85780820151818401526020810190506108ad565b50505050905090810190601f1680156108f55780820380516001836020036101000a031916815260200191505b509350505050600060405180830381600087803b15801561091557600080fd5b505af1158015610929573d6000803e3d6000fd5b505050508173ffffffffffffffffffffffffffffffffffffffff1663e942b516876040518263ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018080602001806020018381038352600c8152602001807f6974656d5f616464726573730000000000000000000000000000000000000000815250602001838103825284818151815260200191508051906020019080838360005b838110156109ed5780820151818401526020810190506109d2565b50505050905090810190601f168015610a1a5780820380516001836020036101000a031916815260200191505b509350505050600060405180830381600087803b158015610a3a57600080fd5b505af1158015610a4e573d6000803e3d6000fd5b505050508273ffffffffffffffffffffffffffffffffffffffff166331afac368a846040518363ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180806020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001828103825284818151815260200191508051906020019080838360005b83811015610b0d578082015181840152602081019050610af2565b50505050905090810190601f168015610b3a5780820380516001836020036101000a031916815260200191505b509350505050602060405180830381600087803b158015610b5a57600080fd5b505af1158015610b6e573d6000803e3d6000fd5b505050506040513d6020811015610b8457600080fd5b810190808051906020019092919050505090507fc57b01fa77f41df77eaab79a0e2623fab2e7ae3e9530d9b1cab225ad65f2b7ce816040518082815260200191505060405180910390a180945050505050949350505050565b600080600080600061100193508373ffffffffffffffffffffffffffffffffffffffff1663f23f63c96040518163ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180806020018281038252600b8152602001807f745f5461626c6554656d70000000000000000000000000000000000000000000815250602001915050602060405180830381600087803b158015610c8a57600080fd5b505af1158015610c9e573d6000803e3d6000fd5b505050506040513d6020811015610cb457600080fd5b810190808051906020019092919050505092508273ffffffffffffffffffffffffffffffffffffffff16637857d7c96040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b158015610d2b57600080fd5b505af1158015610d3f573d6000803e3d6000fd5b505050506040513d6020811015610d5557600080fd5b810190808051906020019092919050505091508173ffffffffffffffffffffffffffffffffffffffff1663cd30a1d1886040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808060200180602001838103835260048152602001807f6e616d6500000000000000000000000000000000000000000000000000000000815250602001838103825284818151815260200191508051906020019080838360005b83811015610e28578082015181840152602081019050610e0d565b50505050905090810190601f168015610e555780820380516001836020036101000a031916815260200191505b509350505050600060405180830381600087803b158015610e7557600080fd5b505af1158015610e89573d6000803e3d6000fd5b505050508173ffffffffffffffffffffffffffffffffffffffff1663e44594b9876040518263ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018080602001838152602001828103825260078152602001807f6974656d5f69640000000000000000000000000000000000000000000000000081525060200192505050600060405180830381600087803b158015610f3557600080fd5b505af1158015610f49573d6000803e3d6000fd5b505050508273ffffffffffffffffffffffffffffffffffffffff166328bb211788846040518363ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180806020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001828103825284818151815260200191508051906020019080838360005b83811015611008578082015181840152602081019050610fed565b50505050905090810190601f1680156110355780820380516001836020036101000a031916815260200191505b509350505050602060405180830381600087803b15801561105557600080fd5b505af1158015611069573d6000803e3d6000fd5b505050506040513d602081101561107f57600080fd5b810190808051906020019092919050505090507f4b930e280fe29620bdff00c88155d46d6d82a39f45dd5c3ea114dc3157358112816040518082815260200191505060405180910390a18094505050505092915050565b60008060008060008061100194508473ffffffffffffffffffffffffffffffffffffffff1663f23f63c96040518163ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180806020018281038252600b8152602001807f745f5461626c6554656d70000000000000000000000000000000000000000000815250602001915050602060405180830381600087803b15801561118457600080fd5b505af1158015611198573d6000803e3d6000fd5b505050506040513d60208110156111ae57600080fd5b810190808051906020019092919050505093508373ffffffffffffffffffffffffffffffffffffffff166313db93466040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b15801561122557600080fd5b505af1158015611239573d6000803e3d6000fd5b505050506040513d602081101561124f57600080fd5b810190808051906020019092919050505092508273ffffffffffffffffffffffffffffffffffffffff1663e942b516896040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808060200180602001838103835260098152602001807f6974656d5f6e616d650000000000000000000000000000000000000000000000815250602001838103825284818151815260200191508051906020019080838360005b83811015611322578082015181840152602081019050611307565b50505050905090810190601f16801561134f5780820380516001836020036101000a031916815260200191505b509350505050600060405180830381600087803b15801561136f57600080fd5b505af1158015611383573d6000803e3d6000fd5b505050508273ffffffffffffffffffffffffffffffffffffffff1663e942b516886040518263ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018080602001806020018381038352600c8152602001807f6974656d5f616464726573730000000000000000000000000000000000000000815250602001838103825284818151815260200191508051906020019080838360005b8381101561144757808201518184015260208101905061142c565b50505050905090810190601f1680156114745780820380516001836020036101000a031916815260200191505b509350505050600060405180830381600087803b15801561149457600080fd5b505af11580156114a8573d6000803e3d6000fd5b505050508373ffffffffffffffffffffffffffffffffffffffff16637857d7c96040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b15801561151057600080fd5b505af1158015611524573d6000803e3d6000fd5b505050506040513d602081101561153a57600080fd5b810190808051906020019092919050505091508173ffffffffffffffffffffffffffffffffffffffff1663cd30a1d18b6040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808060200180602001838103835260048152602001807f6e616d6500000000000000000000000000000000000000000000000000000000815250602001838103825284818151815260200191508051906020019080838360005b8381101561160d5780820151818401526020810190506115f2565b50505050905090810190601f16801561163a5780820380516001836020036101000a031916815260200191505b509350505050600060405180830381600087803b15801561165a57600080fd5b505af115801561166e573d6000803e3d6000fd5b505050508173ffffffffffffffffffffffffffffffffffffffff1663e44594b98a6040518263ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018080602001838152602001828103825260078152602001807f6974656d5f69640000000000000000000000000000000000000000000000000081525060200192505050600060405180830381600087803b15801561171a57600080fd5b505af115801561172e573d6000803e3d6000fd5b505050508373ffffffffffffffffffffffffffffffffffffffff1663bf2b70a18b85856040518463ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180806020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001828103825285818151815260200191508051906020019080838360005b83811015611820578082015181840152602081019050611805565b50505050905090810190601f16801561184d5780820380516001836020036101000a031916815260200191505b50945050505050602060405180830381600087803b15801561186e57600080fd5b505af1158015611882573d6000803e3d6000fd5b505050506040513d602081101561189857600080fd5b810190808051906020019092919050505090507f8e5890af40fc24a059396aca2f83d6ce41fcef086876548fa4fb8ec27e9d292a816040518082815260200191505060405180910390a18095505050505050949350505050565b600080600061100191508173ffffffffffffffffffffffffffffffffffffffff166356004b6a6040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808060200180602001806020018481038452600b8152602001807f745f5461626c6554656d70000000000000000000000000000000000000000000815250602001848103835260048152602001807f6e616d65000000000000000000000000000000000000000000000000000000008152506020018481038252601e8152602001807f6974656d5f69642c6974656d5f6e616d652c6974656d5f6164647265737300008152506020019350505050602060405180830381600087803b158015611a0e57600080fd5b505af1158015611a22573d6000803e3d6000fd5b505050506040513d6020811015611a3857600080fd5b810190808051906020019092919050505090507fb5636cd912a73dcdb5b570dbe331dfa3e6435c93e029e642def2c8e40dacf210816040518082815260200191505060405180910390a1809250505090565b606080606060008060008060608060608060008061100199508973ffffffffffffffffffffffffffffffffffffffff1663f23f63c96040518163ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180806020018281038252600b8152602001807f745f5461626c6554656d70000000000000000000000000000000000000000000815250602001915050602060405180830381600087803b158015611b4357600080fd5b505af1158015611b57573d6000803e3d6000fd5b505050506040513d6020811015611b6d57600080fd5b810190808051906020019092919050505098508873ffffffffffffffffffffffffffffffffffffffff16637857d7c96040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b158015611be457600080fd5b505af1158015611bf8573d6000803e3d6000fd5b505050506040513d6020811015611c0e57600080fd5b810190808051906020019092919050505097508873ffffffffffffffffffffffffffffffffffffffff1663e8434e398f8a6040518363ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180806020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001828103825284818151815260200191508051906020019080838360005b83811015611cdc578082015181840152602081019050611cc1565b50505050905090810190601f168015611d095780820380516001836020036101000a031916815260200191505b509350505050602060405180830381600087803b158015611d2957600080fd5b505af1158015611d3d573d6000803e3d6000fd5b505050506040513d6020811015611d5357600080fd5b810190808051906020019092919050505096508673ffffffffffffffffffffffffffffffffffffffff1663949d225d6040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b158015611dca57600080fd5b505af1158015611dde573d6000803e3d6000fd5b505050506040513d6020811015611df457600080fd5b8101908080519060200190929190505050604051908082528060200260200182016040528015611e335781602001602082028038833980820191505090505b5095508673ffffffffffffffffffffffffffffffffffffffff1663949d225d6040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b158015611e9a57600080fd5b505af1158015611eae573d6000803e3d6000fd5b505050506040513d6020811015611ec457600080fd5b8101908080519060200190929190505050604051908082528060200260200182016040528015611f035781602001602082028038833980820191505090505b5094508673ffffffffffffffffffffffffffffffffffffffff1663949d225d6040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b158015611f6a57600080fd5b505af1158015611f7e573d6000803e3d6000fd5b505050506040513d6020811015611f9457600080fd5b8101908080519060200190929190505050604051908082528060200260200182016040528015611fd35781602001602082028038833980820191505090505b5093508673ffffffffffffffffffffffffffffffffffffffff1663949d225d6040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b15801561203a57600080fd5b505af115801561204e573d6000803e3d6000fd5b505050506040513d602081101561206457600080fd5b81019080805190602001909291905050506040519080825280602002602001820160405280156120a35781602001602082028038833980820191505090505b509250600091505b8673ffffffffffffffffffffffffffffffffffffffff1663949d225d6040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b15801561210f57600080fd5b505af1158015612123573d6000803e3d6000fd5b505050506040513d602081101561213957600080fd5b8101908080519060200190929190505050821215612602578673ffffffffffffffffffffffffffffffffffffffff1663846719e0836040518263ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180828152602001915050602060405180830381600087803b1580156121c057600080fd5b505af11580156121d4573d6000803e3d6000fd5b505050506040513d60208110156121ea57600080fd5b810190808051906020019092919050505090508073ffffffffffffffffffffffffffffffffffffffff166327314f796040518163ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018080602001828103825260048152602001807f6e616d6500000000000000000000000000000000000000000000000000000000815250602001915050602060405180830381600087803b15801561229d57600080fd5b505af11580156122b1573d6000803e3d6000fd5b505050506040513d60208110156122c757600080fd5b810190808051906020019092919050505086838151811015156122e657fe5b9060200190602002019060001916908160001916815250508073ffffffffffffffffffffffffffffffffffffffff1663fda69fae6040518163ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018080602001828103825260078152602001807f6974656d5f696400000000000000000000000000000000000000000000000000815250602001915050602060405180830381600087803b15801561239e57600080fd5b505af11580156123b2573d6000803e3d6000fd5b505050506040513d60208110156123c857600080fd5b810190808051906020019092919050505085838151811015156123e757fe5b90602001906020020181815250508073ffffffffffffffffffffffffffffffffffffffff166327314f796040518163ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018080602001828103825260098152602001807f6974656d5f6e616d650000000000000000000000000000000000000000000000815250602001915050602060405180830381600087803b15801561249557600080fd5b505af11580156124a9573d6000803e3d6000fd5b505050506040513d60208110156124bf57600080fd5b810190808051906020019092919050505084838151811015156124de57fe5b9060200190602002019060001916908160001916815250508073ffffffffffffffffffffffffffffffffffffffff166327314f796040518163ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180806020018281038252600c8152602001807f6974656d5f616464726573730000000000000000000000000000000000000000815250602001915050602060405180830381600087803b15801561259657600080fd5b505af11580156125aa573d6000803e3d6000fd5b505050506040513d60208110156125c057600080fd5b810190808051906020019092919050505083838151811015156125df57fe5b9060200190602002019060001916908160001916815250508160010191506120ab565b8585859c509c509c505050505050505050505091939092505600a165627a7a72305820eff4df7fa7f9da63b6830154a03f5bbb077bebee186d5b96817e4a1609cefd4b0029";

    public static final String ABI = "[{\"constant\":false,\"inputs\":[{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"item_id\",\"type\":\"int256\"},{\"name\":\"item_name\",\"type\":\"string\"},{\"name\":\"item_address\",\"type\":\"string\"}],\"name\":\"insert\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"item_id\",\"type\":\"int256\"}],\"name\":\"remove\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"item_id\",\"type\":\"int256\"},{\"name\":\"item_name\",\"type\":\"string\"},{\"name\":\"item_address\",\"type\":\"string\"}],\"name\":\"update\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[],\"name\":\"create\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"name\",\"type\":\"string\"}],\"name\":\"select\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes32[]\"},{\"name\":\"\",\"type\":\"int256[]\"},{\"name\":\"\",\"type\":\"bytes32[]\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"count\",\"type\":\"int256\"}],\"name\":\"CreateResult\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"count\",\"type\":\"int256\"}],\"name\":\"InsertResult\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"count\",\"type\":\"int256\"}],\"name\":\"UpdateResult\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"count\",\"type\":\"int256\"}],\"name\":\"RemoveResult\",\"type\":\"event\"}]";

    public static final String FUNC_INSERT = "insert";

    public static final String FUNC_REMOVE = "remove";

    public static final String FUNC_UPDATE = "update";

    public static final String FUNC_CREATE = "create";

    public static final String FUNC_SELECT = "select";

    public static final Event CREATERESULT_EVENT = new Event("CreateResult", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
    ;

    public static final Event INSERTRESULT_EVENT = new Event("InsertResult", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
    ;

    public static final Event UPDATERESULT_EVENT = new Event("UpdateResult", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
    ;

    public static final Event REMOVERESULT_EVENT = new Event("RemoveResult", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
    ;

    @Deprecated
    protected TableTemp(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected TableTemp(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected TableTemp(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected TableTemp(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<TransactionReceipt> insert(String name, BigInteger item_id, String item_name, String item_address) {
        final Function function = new Function(
                FUNC_INSERT, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(name), 
                new Int256(item_id),
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(item_name),
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(item_address)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void insert(String name, BigInteger item_id, String item_name, String item_address, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_INSERT,
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(name),
                new Int256(item_id),
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(item_name),
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(item_address)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String insertSeq(String name, BigInteger item_id, String item_name, String item_address) {
        final Function function = new Function(
                FUNC_INSERT,
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(name),
                new Int256(item_id),
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(item_name),
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(item_address)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public RemoteCall<TransactionReceipt> remove(String name, BigInteger item_id) {
        final Function function = new Function(
                FUNC_REMOVE,
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(name),
                new Int256(item_id)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void remove(String name, BigInteger item_id, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_REMOVE,
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(name),
                new Int256(item_id)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String removeSeq(String name, BigInteger item_id) {
        final Function function = new Function(
                FUNC_REMOVE,
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(name),
                new Int256(item_id)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public RemoteCall<TransactionReceipt> update(String name, BigInteger item_id, String item_name, String item_address) {
        final Function function = new Function(
                FUNC_UPDATE,
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(name),
                new Int256(item_id),
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(item_name),
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(item_address)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void update(String name, BigInteger item_id, String item_name, String item_address, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_UPDATE,
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(name),
                new Int256(item_id),
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(item_name),
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(item_address)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String updateSeq(String name, BigInteger item_id, String item_name, String item_address) {
        final Function function = new Function(
                FUNC_UPDATE,
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(name),
                new Int256(item_id),
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(item_name),
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(item_address)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public RemoteCall<TransactionReceipt> create() {
        final Function function = new Function(
                FUNC_CREATE,
                Arrays.<Type>asList(),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void create(TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_CREATE,
                Arrays.<Type>asList(),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String createSeq() {
        final Function function = new Function(
                FUNC_CREATE,
                Arrays.<Type>asList(),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public RemoteCall<Tuple3<List<byte[]>, List<BigInteger>, List<byte[]>>> select(String name) {
        final Function function = new Function(FUNC_SELECT,
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(name)),
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Bytes32>>() {}, new TypeReference<DynamicArray<Int256>>() {}, new TypeReference<DynamicArray<Bytes32>>() {}));
        return new RemoteCall<Tuple3<List<byte[]>, List<BigInteger>, List<byte[]>>>(
                new Callable<Tuple3<List<byte[]>, List<BigInteger>, List<byte[]>>>() {
                    @Override
                    public Tuple3<List<byte[]>, List<BigInteger>, List<byte[]>> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<List<byte[]>, List<BigInteger>, List<byte[]>>(
                                convertToNative((List<Bytes32>) results.get(0).getValue()),
                                convertToNative((List<Int256>) results.get(1).getValue()),
                                convertToNative((List<Bytes32>) results.get(2).getValue()));
                    }
                });
    }

    public List<CreateResultEventResponse> getCreateResultEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(CREATERESULT_EVENT, transactionReceipt);
        ArrayList<CreateResultEventResponse> responses = new ArrayList<CreateResultEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            CreateResultEventResponse typedResponse = new CreateResultEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.count = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<CreateResultEventResponse> createResultEventFlowable(BcosFilter filter) {
        return web3j.logFlowable(filter).map(new io.reactivex.functions.Function<Log, CreateResultEventResponse>() {
            @Override
            public CreateResultEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(CREATERESULT_EVENT, log);
                CreateResultEventResponse typedResponse = new CreateResultEventResponse();
                typedResponse.log = log;
                typedResponse.count = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<CreateResultEventResponse> createResultEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        BcosFilter filter = new BcosFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CREATERESULT_EVENT));
        return createResultEventFlowable(filter);
    }

    public List<InsertResultEventResponse> getInsertResultEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(INSERTRESULT_EVENT, transactionReceipt);
        ArrayList<InsertResultEventResponse> responses = new ArrayList<InsertResultEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            InsertResultEventResponse typedResponse = new InsertResultEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.count = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<InsertResultEventResponse> insertResultEventFlowable(BcosFilter filter) {
        return web3j.logFlowable(filter).map(new io.reactivex.functions.Function<Log, InsertResultEventResponse>() {
            @Override
            public InsertResultEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(INSERTRESULT_EVENT, log);
                InsertResultEventResponse typedResponse = new InsertResultEventResponse();
                typedResponse.log = log;
                typedResponse.count = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<InsertResultEventResponse> insertResultEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        BcosFilter filter = new BcosFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(INSERTRESULT_EVENT));
        return insertResultEventFlowable(filter);
    }

    public List<UpdateResultEventResponse> getUpdateResultEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(UPDATERESULT_EVENT, transactionReceipt);
        ArrayList<UpdateResultEventResponse> responses = new ArrayList<UpdateResultEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            UpdateResultEventResponse typedResponse = new UpdateResultEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.count = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<UpdateResultEventResponse> updateResultEventFlowable(BcosFilter filter) {
        return web3j.logFlowable(filter).map(new io.reactivex.functions.Function<Log, UpdateResultEventResponse>() {
            @Override
            public UpdateResultEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(UPDATERESULT_EVENT, log);
                UpdateResultEventResponse typedResponse = new UpdateResultEventResponse();
                typedResponse.log = log;
                typedResponse.count = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<UpdateResultEventResponse> updateResultEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        BcosFilter filter = new BcosFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(UPDATERESULT_EVENT));
        return updateResultEventFlowable(filter);
    }

    public List<RemoveResultEventResponse> getRemoveResultEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(REMOVERESULT_EVENT, transactionReceipt);
        ArrayList<RemoveResultEventResponse> responses = new ArrayList<RemoveResultEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            RemoveResultEventResponse typedResponse = new RemoveResultEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.count = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<RemoveResultEventResponse> removeResultEventFlowable(BcosFilter filter) {
        return web3j.logFlowable(filter).map(new io.reactivex.functions.Function<Log, RemoveResultEventResponse>() {
            @Override
            public RemoveResultEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(REMOVERESULT_EVENT, log);
                RemoveResultEventResponse typedResponse = new RemoveResultEventResponse();
                typedResponse.log = log;
                typedResponse.count = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<RemoveResultEventResponse> removeResultEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        BcosFilter filter = new BcosFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(REMOVERESULT_EVENT));
        return removeResultEventFlowable(filter);
    }

    @Deprecated
    public static TableTemp load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new TableTemp(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static TableTemp load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new TableTemp(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static TableTemp load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new TableTemp(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static TableTemp load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new TableTemp(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<TableTemp> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(TableTemp.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<TableTemp> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(TableTemp.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<TableTemp> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(TableTemp.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<TableTemp> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(TableTemp.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class CreateResultEventResponse {
        public Log log;

        public BigInteger count;
    }

    public static class InsertResultEventResponse {
        public Log log;

        public BigInteger count;
    }

    public static class UpdateResultEventResponse {
        public Log log;

        public BigInteger count;
    }

    public static class RemoveResultEventResponse {
        public Log log;

        public BigInteger count;
    }
}
