package myHash;

public class CuckooHash 
{
	final int HASHSIZE = 99991;
	HashNode [] T1;
	HashNode [] T2;

	public CuckooHash()
	{
		T1 = new HashNode[HASHSIZE];
		T2 = new HashNode[HASHSIZE];
	}

	private int h1(int K)
	{
		return K % HASHSIZE;
	}

	private int h2(int K)
	{
		return (2*K) % HASHSIZE;
	}

	public void insert(HashNode node)
	{



		if(T1[h1(node.key)]==null){

			T1[h1(node.key)]=node;



		}else if(!(T1[h1(node.key)]==null)){

			if(T1[h1(node.key)].key==node.key){
            //check duplicate nodes

			}else{

				if(T2[h2(node.key)]==null){

					T2[h2(T1[h1(node.key)].key)]=T1[h1(node.key)];

					T1[h1(node.key)]=node;


				}else if(!(T2[h2(node.key)]==null) ){



					rehashing(node,T1[h1(node.key)]);

				}

			}

		}

	}


	public void rehashing(HashNode node,HashNode moved){

		T1[h1(node.key)]=node;


		if(T2[h2(moved.key)]==null){

			T2[h2(moved.key)]=moved;


		}else{

			T2[h2(moved.key)]=moved;

			if(T1[h1(T2[h2(moved.key)].key)]==null){

				T1[h1(T2[h2(moved.key)].key)]=T2[h2(moved.key)];

			}else{

				moved=T1[h1(T2[h2(moved.key)].key)];

				rehashing(T2[h2(moved.key)],moved);

			}

		}

	}


	public boolean find(HashNode node)
	{
		// First find the hash of node.key and the use it to see
		// if there is something with that key and value already stored.
		// If so, return true, else return false.

		boolean result=false;

		int node_h1=h1(node.key);

		int node_h2=h2(node.key);

		if(T1[node_h1]!=null){

			if(T1[node_h1].key==node.key){


				result=true;

			}else if(T2[node_h2]!=null && T2[node_h2].key==node.key){


				result=true;
			}else{

				result=false;
			}
		}else{

			result=false;
		}

		return result;
	}

	public void remove(HashNode node){


		if(T1[h1(node.key)]!=null){

			if(T1[h1(node.key)].key==node.key){

				T1[h1(node.key)]=null;

			}else if(T2[h2(node.key)]!=null || T2[h2(node.key)]==node){

				T2[h2(node.key)]=null;
			}
		}
	}



}
