package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;

import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.util.Log;


import java.util.ArrayList;

public class AllBooksActivity extends AppCompatActivity {
    private static final String TAG = "AllBooksActivity";
       
    private RecyclerView bookRecView;
    private CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);
        Log.d(TAG, "onCreate: started");

        bookRecView = (RecyclerView)findViewById(R.id.booksRecView);

        BooksRecyclerViewAdapter adapter = new BooksRecyclerViewAdapter(this);
        bookRecView.setAdapter(adapter);
        bookRecView.setLayoutManager(new GridLayoutManager(this,2));


//        books.add(new Book("Wings of fire","APJ abdul kalam",1350,
//                "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcScif-JhKkirJZ6_Xo1VshaMATPafMHJtDh5Ql3WBhtMbK90DrW&usqp=CAU",
//                "Motivational book"));
//        books.add(new Book("Rich Dad poor Dad","Robert Kiyosaki",346,
//                "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQSsj8eR2vFCzU-pwh-tQgu8Yuwc5Uj21-882bLivYOFwDVPrH6&usqp=CAU",
//                "Self Improvement Book"));
//        books.add(new Book("Power Of Subconscious Mind","Joseph Murphy",178,
//                "data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBxISEhUSEhMWFRUVFhUXFhUVFxUVFxYVFxoYFhcWFRgYHSggGBolGxgXITEhJSkrLi4uGB8zODMtNygtLisBCgoKDg0OGxAQGi4lHyUtLS0tLTUuLS0vLSstLS0tLS8rLTAvLTAtKy0tLS0tLS0tLS0uLSstLS8tLS0tLS0tLf/AABEIARcAtQMBIgACEQEDEQH/xAAcAAAABwEBAAAAAAAAAAAAAAAAAQIEBQYHAwj/xABREAACAQIEAgcDBgcLCwUBAAABAgMAEQQFEiExUQYHEyJBYXEygZEUQlKhsbIjYnJzksHRCBUkJTM1U3ST0uEWQ1RjZIKDs8LD8BdEouLxNP/EABoBAQEBAQEBAQAAAAAAAAAAAAABAgMEBQb/xAAtEQACAgEEAgECBgEFAAAAAAAAAQIRAxIhMUEEURNhwSJxgZGx0aEFFBUy8f/aAAwDAQACEQMRAD8A2NVpYpK03xltcV7e03H8hqw9ixVseWorU2wa2eQL7Hdty1b6gPLh9dMMsazIW7txIoIOzHWSAeRAG3qalm9HJLgUNNKptjTvH+cX7DVaMJW6O9qK1cy3fIPCwt9d/wBVBF2YX2uben/7esijpYULUmE7G9tuXA+dJwvsj0FWhR1Ao7VwgW+48Cw9d6ZsT/CbEWHP82POl0aULJOirlgz+DT8lfsFNM01akKXump7D5wFgV94Y++1G9rIo3KiQpBkWxNxYcTfYetMcGxMzMb2eNWAPgAWAHrYg++uOk6Jo/nM76RbiHsQR5b8fKmo18e5JSSqttRAvwvtfx2pYdbar7Wvcbi3OmWZKxeHTxEjG9iQPwbi5t4XI+NDDAiAroIZVI08yAfZPiD+upe40Kkx8rA8K5/KU0h790kAGx4k6R9dKhXYHxIF/wBlRy4RuxUWbUHUkX8BJfhe3CrbEYxb3JNpAGCnib25bcRfnSVIIuPrrnj4iyWXjcEeHjvv6XpzVMtKjkVoUsihWdJkIUpaQK6LWwHSSKOhQBUlkBIJ8DcevClUKABoqDNYXPhSYnDAMOBF6lq6FOrFihSZUv60Sgjia4vJJSpx29mqVciBIdQWw8TXRzbcC/lzokkvvRfKF51iGSCjbns+COzovDcW8q5zTqttRAvfj5UjFz2QkcfDakYjDLIq6t9JDDkSOdd4zTek5yb65Gud5iYuyA2MkqJc8AvFiTwBttUleo/D45ZJDHoIKC5uB3Te1v8AEUUk8xmEaqAgGppTuCt7aFH0v1V2q1SOcZ7uV2uB1jZikbuF1FVJCjxtvaumHmDqGHBgCLgjY+RpdCs9HXew6OioVCh0KFHQoVCgaFAIFLFJo1oQOivR1znYhSQLkAkDmfAUKlbOEmZRK2hnAI48h42J4A+VE2aQg27Rfjceu3h51lGOzJ2dgSwGpjpJ4EnvX8674CR5GAQMzbcBfavBLy5XSR+h/wCDSgpSkai2IjkXTq2e4HEE242vSY5VKmNG1FVt8NgCedQuYYKQiPs2YhiNY7vda27Ej2bjwqRwuBYAKCgQAiwuWPmW53rblKUq0nynjhGN6v0HZlfRqIsQNxxv510juyDzFcGnKaY/ac+J4W5mushUi+q1vEHga4yjV7t7U03X+fZza+nYuKELShEL6rb0jDqLcbnnXQeZrpgxQjiitCS67r9TlLkMC/ECucs4W1+B8fD38qOZSRYcL7+lDUCSvIb++uznT0/s32zDRwQw6tYKa22vcXPlSXnftVjCELZmZ+IsNgo5Ek+PKu0OGReCj1tv8aUk6ngwrtBtL8XJzrb0M8xScvF2RAUFu0J37tvAeJuOPhUhSaMVu9jSjTbFUKKjqFDFChQqlBQoUKgELSlpIpS0IKprmThYnZjpCqTq+jbfV7qdVQetPOtEa4VDvJ3n8kHAH1P2VpK9j1eHgefNHGu3/gpWMxnaPcXtwUnc2uTcnnuTUnkaYgJJJFIyJGAXK3+FhxNVmBjbUQQL8fA24/aK1TLAnybssOpkQpuxspu3G4sLmvBk8epWz9l/qGVYMUYRVp7b8V/ZGdHIu1RpZpXWIN3gbgMxPib7+e1WfLMUXLFBpUDTEnsgj6XnUZgsgQRDVM0igWVPZVT5gePrUrl0KFFBDMY9rnb7KmODjR+e8vJjm5SXv1x/BImWylpFA0jnce6kGGNrSbbb7cDTcTCXUlrgEWvw2pQxDqRGIwDz+aBWsmmS/ErX3PnqDXHP2HkE2q5GyjhXKJy4f1291d1U2sbe6ueGw+jYHjXDLgy5JQi/+tPV1zxsc7ik/fQuAG2/E8a5wRsGYnx8f8KGIlZfT7DXaM7C/Ks4fheWOBXeNX9v1szJOtXs4yynWqjzJ/VSmwyFtRUE7bkX4V0KAm9t+dB3AFzwr3RTjqc33+yOVB0KJTcXtajrsne4DoUVHVAoUKFCqAUKFCoUQKUtIFLWhAzXn3pVipGxc5mvrEjC3IA2UDy02rbOk+ex4LDtM+5GyL4u54KP1+VedcXmDyyPK5u7sWY+ZNzXr8aDds+r/peX48jkTeX5loYPoUlRYXFxqsbMRwJHH3Va5c+bDlRDiO2EgUyHxDbXC34VQsI/MX2Pu8x51ceh3ZzzaJFj7NbOzEAWCjSq+87+6ufkYrP02b45Q+SStJbmkZehKklAgfvG51Ek+PIUrA7Fl12F9geVRGVyPJL3HLRrcN5WNrDnUwsUU/ft/JtbkduN68FH5nNHQ2pf+ejs2JWMoAQQzab+dOsRMANyBUVmjwyaVMgTSQbHYm1FiMTh5iqh7lSNhuTUcmrRy+K0pU/qSmFkLLdth4HxPnS4LWvcnzPjQV1YHy8OXlRYSVWXujYeFVRVrc80t09hSur3HEC1dFI9keH1UxbEJGxJDAny/wDBTyJ7i9iPXia8+GcZTpta+/y6E4tK+hKoSe9wHAc/M12NJBN96Ou/j41GL5e75OTDoUKFekyCjoUKFDFHRUdUgKFChUKck4Uta5rwpa0RDL+t3IcZK3ylCHw8UdylwDHa5drH2ri3DfasjDV6I6ycKJMuxAMjRhVDkqCb6CDoIHEHga846q+p4r1Qr0dIZNLJTL1d2CKLtueIGwBYm524A1d+iEUWp8Ji4VjMkZcyuxBVeKkgmwN7W4fXWf4OZdQMjPpG3dtq0kEbX2sNtjxG1HHNvxJq5Md7H3vG8l5Y/G5UbR0HlgSCfsHvKO0spJPdS4RivAX4++u2D6RsuH7dVVhLu2ki6S8CGHLxrN8k1LE0nblItaJKsZIfSSe8bbW3PHjWu4Ho9BDB2cMYkDWYmQ+1sLEn05V8zPjrgvlxw45OU3q1P+ObZKdkjxAyqp7oN7A22qEwkRiR+wXUSSdZA4H6NOoGkeQxuojRALKDcOeV+VTGGlUr3RYDa1rbjwrzOKkfMeR4k1yn10JwEQWML5XN+NzxvSElCpqjGykgj0NjTDJpTMcRruLvYA+CgW2p5l+WiIvZiVbgpN7HxN/OitpaUcpxUZPU9w8FKJ1uwBAbb3U9L0iKNE7qgC9zYfXSzbxrWOGlb89s4Tlqe3Akv5Uta5tKo4sB6kCkfLI/6RP0l/bXS0+DHA4oU2OYQ/0sf6a/tpJzSAcZov00/bVIOxR0wOc4Yf8AuIf7RP20X7+YX/SIf7RP20BI0Kjjn2F/0iH+0T9tCPPcKxCjEREkgAB1JJPAAA1QSVCioVAcxwpS0gUtBQpBdO8z+TYDESgAkJpAO41PZBfyu1eaEFesMZhUlRo5FDowsysLgjkRVWl6tMrY3+TkfkySge4aq9nj54400znKLbtHnuNS7BVBLMQABuSTsAPO9WDLujxklgiRrPIWEimzdlotqd9JFlseB3FjVs6xOruLCQHFYRnAjK642Oqyk21I3EWJF732qg5bIju7zTvG2hzcBmaRiCdJN9rnnXs1rJG4nfFlcHsaEmHLYXE4DDt2+mYIgLxIx7PS7uibM1zqHE7CrtA+Jw2BWTaSWOPvrJ3O6OAGm+68POqD0c6JYtYY8Xl+LQGSMa9QKFTxZVJVtQB8hwp50Ow+Lxss3aY11GoLLZSDIBsNLEAKOO31V4ckU+z6kZxyR/FJUnb9svmRXYJNOwaaUXUC4CLa9gD9tP8AGYqRLARarkC4PPxNV7BYyFcakKAhIlaNDu4eRrFu9zAG9+dTWc5hLEUSNNRkbSrE7KTzrxyVHDLjbyrblX62JBg4TugauXAV0gZiO8uk8r3+Fc8Dhii95izHdmPifIeArll+YrKXABBQ6WuNtW9wD4/41FseNpu63rsL5O/yjtNtATSOYJNz68Ka5l/Kt+ZP66maicZ/Lna/4I7c+O1ebyo1Db2dsErlv0ihdLOy7OMzi8YlGoWJv3XtsN+NqgDFlzL+DwxYatnVHdgNd7EBvo2Fj51bumeCSXDoWUJ32Okahq0IzAbAtudtheqBDl8YbZT3ljIH4cICzOpFwO0FwosSCASb32vPBi44q+pPMkpZbJCYZah1NDYGS4VozqVezAsRruV16ja3ivCoLO8RhXCDDx6LX1bG5GmOxJubnV2m/pQzOALHGOzAIaZWfclir2sTwJ9KCYaM/N3WJG31tqZtN9k3sL+HxtXuS9nkddESuxrshqWgyxC4XSbM4HByRdVLAAEabFuLHw4ca54TD7fyfGB2L3YWYo1/HTsbra16EGLPWsdWHRXQBi5l75H4NT80Hix/Gt8KzTMIQlmVdNnsLhlbhccSQ1re0D7txWw9XnSpMXCI2ss8QAZeAdfpr+seB9azJNtejcWki30KFCqDmpoNKqi7EAX4kgD66JaqPWhf5Gv55fuvUIWs46L+kT9Nf20aYyNtlkQ+jKfsNZ1gerCKaJJHxU4LqGIURWFxewupNCXqgj+ZjJwfDUsTD6gD9dUGh5hg0mieGQXSRWRh5MLGvMfSXIZcFiZIHBOjcPbZoz7L+V+HretJwWMx2T4yLD4iXtsNMbKxvbltqJKkXG17b0+668MywRYuN2UqTE+kka45AbA7WO/Pma9Xi5HGWn2ZfsZ9XHSdRggk2IRDAbIhKAmPwB3uRe44Dwq1w4aXFKZGlWONtlaPY6D7W/gTwvUR1f8AQiPD4UTNolmlRXBIuEUgHsxxuOZp+mSwYwxsgeFA15YTrRZLfi3sRfx8aZXFydHWEq3JqGGOOAJglidltpBfbc94lhc3IvvUrhXZheSPQw8Lhh6gj/ClQYdEFkUKB4AAfZXWvKWU7OEuMRW0swUkXGra/oTsaVAiblAveNyVtueZtxNCfDq4AdQwBBF99xwNLVQNgLelQzarYVTPF4AO2rUym1tqd0KzOEZqpCE3B2ivZ70TTFIEeaUWYMGXTcEX5jzqDHVdBfV8pxFzxN0ufU6d6v1CkIKCqInJydsoA6qcJw7ae3K6f3aNeqnCDftp/cyD/pq+0K2Zoog6q8H/AEs/6Sf3KMdVeD/pJ/00/uVe6Ogooo6rcF9Of9Nf7tO8s6vMJh5UmieZXQ3B7Qe8EadwfEVbqOgBQoUKFOS1TetaTTg1P+uX7r1clqh9c0/Z4BG/2hPuyVCMuuUW7CK247NLelhTusqy/rjwMcaRlJCVQA2AtcDwosR13YbcRYaV28BdRf4A1QOuvJwIMKfnDEd3n7Jvb6qu2Lw0EmFAxSI8YRWcSAFe6AbkHlWXZTgcfneNixWMiMGEgIZEYFdRBuAobdtwLt5VM9bGYtJLhcribScQ69oR/R3tb37/AAq3RByvSzF4wmPKsOohTu9vJ3Y9trIBxFJnyzP0764mJz9AKAPQXq85dhIsNEkMahVUBVAHKngIpYooXRzp3IJhhcwj7KU7K/BSeR5VI9YWbYnCRxTwMAgcCUaQe6eB34U260sjWbCNOotLD3ww4kDiK6ZKwzLKdL7l4yh/KXgfsqAtmDxAkjWReDKGHvrtVI6rcxLYdsO/t4dipB5VYulGZfJsJNN4qh0/lHZfroUVlefYfEvJHC+pozZ9iLbkbE8dwak6xjock+X4rDtMRpxin3XI4+e4NbLegKh1ldI5MJDGsDaZpXAUgAkKOOx87D31LnMhg8Gs2MkuUQF22uzn5qgcTfYCqVN/GGdheMWEFzyuu/1tb4Uz61MUcRjoMDrCIqh3JNlDOSNR/JQf/KhBK9Js2zR2XAp2MKkjVcKB5PKQbt5INqcf5L59F+ETFq7DfT20m/kNa6T77VdcrzXLsPEkMWIgVEAAAkT3k78TxNOv8qMD/pUP9ov7aAqvRPp3KZvkeYRmKcbAkab8rjgb/SGxq85lIVhlZTYiNyDyIUkGs/6yp8FicOJ4sRCcRhyHjKuuphfvR7cb8R5irZluPGIwHafSga/roN6FMzg6fY7sBDFqmxU76Ua2oqLXOkWtfhx2FiTVy6vsnzGJpJcfJqLqAFMrSFTcHceyvuqO6nsAhjecgFwdAPIWF7Vo9AHRUKFAcl4VnfXq38Wr/WI/uyVog4VnXXz/ADav9Yj+69EGWjofgYGwOGYQx7wxn2F8VF/CpuLBxqbrGinmFUfYKiuhBBy/CEcOwjt+iKm6ABrHOsZ+wz/L5pNoyEsfMMVP2r8a2Oqf1m9Dv3ywulCFniJeFjwJ8UJ8Adt/AgUBbJUva3gb/URXJsOdrctxzrK+iPWh8mAwebI8M0Xd7QqTcDYaxx94uDVxm6ysqVdXyxD5LqLfC1AOum2KWDL8S7nbs2A9TsBUT1Nof3tjYj2mcj0vaqNnueYnpFOuEwUbJhUYGSVhYW+k/LbgvE1s2U5cmHhjgjFljUKPd4nzqgojKcFnW20eLS/lqHH6/tpXWxijJ8lwSHvTzLcDkOH1m/uqS6zsNbDri1F2wrazz0HZv1H3VTeheZnNc1jmI7uGjZj+Ue6v2n4VCFr6ystC4KOVRvhHjYH8UWVv1GpvMM8SLAtiye6ItQ8yRsPjUpmmBWeGSFvZkRkPowIrAps+xGJihyXSQ6Tdk7fSCNpG3IcfdQGkdUGWsuGfFSfymJctc8dIJt8Tc1WOsTLEfO4UnYpDiI4+8psbqSrKD4Hh+lWuZfg1hiSJPZjVVHootVe6wuiX74YcBGCTxHXC/CzeKsfon6tjQtEVH1R5eODYj+1/+tdf/SfL/pT/ANoP7tQPR/rMbCH5JmkUkcibarcRz5EeYqxYvrVyxE1CRn29lUNz5XNh9dCbDLH9WuVQr2k0kqKCBdprC54DhVnynC4ePBMuFcvFok0ktq8CCAfWs2XG4vpBiFCIYsHGfa4qPAm/B5LbWGwrWTg0hwxijFlSJlUeQU0KUzqZkvhZBycH4gfsrQjWb9SkwbDy2+mp9xG1aRQIKhR0VCnIU1zPKYMUnZ4iJZUDBtLi41C4B9dz8adgUpaEOeEwqRIscahEQBVVdgqjgAOVdaFFegDoqF6F6Aj82yLDYoacTBHKBw1qCR6HiPdUDF1Y5SrahhFPkWkYfAtardR3oDhgcFFCgjhjWNBwVFCqPcK70L0VAIxEKyKyOoZWBDKdwQdiCKY5RkOFwur5PBHFqtq7NQuq3C9vU1I0L0AKjkyLCib5QMPEJrlu10Lr1EWJ1Wve21SF6MkUADQotVQWOLTYv5OZHjjWES2jbQ0rM7LbUO8FUKDYEe2KAeZ/hMI8ROMSJo1t/KqpAJNha/iTyqJwnQHKgRImDiN7EXUkb7jusbD4VFZjCzyfJ3mldIcbhgjhyHAlUsY5GX2mSwIJ3AYeO9WbPXeFIpUZisTp2gJvqhbuOW5lQdd/xTQErDEqKFRQqjYBQAB6AcK6EX2NVHD4qXEzXEjpBNJIqFTpJjgGmynwMjl21DfSgtTzGM0LGNJHK6Y37zFmT8KqnvHvaWBPE/NNATWDwEUVxFGkd+OhQt/W1Oar3SvFslgjlT2OJYAG3soLN7ialsqw/ZxKC7OSAWdySSxG58h5DYUA7oqOhQpwpai/GiFNczxpiQFV1uzBEW9gWPM+A8al1uWMXJ0h32Y5D4UNA5D4VErmc6iTtoQCia1ZGLI/4tyAQaf5die1ijktbWitbjbUAbUUkzUsUoq2KxEsca6pCqLcC7EAXJsBc+JO1ddA5D4VRul2cdrhcRqXSMPjIEve9wrxuW4bceHlUpHnGPlHaQ4NBEd1E0pSRl8DpCkLfwBNY+RXR6H4ctClxu+Wl6/ssugch8KPQOQqHy3pFFJDJK94jDcTI/tRMu5Btx8iONMoc5x8y9pBhEER3XtpSkjr4EKFIW/mautHNeNktp7V7dFl0DkPhQ0DkPhUNgukkTQyySAwmC/bRv7SEfeB8CONNYs1zCRe0jwkaxndVllKysvMgKQpPImjmgvGnbvb83RY9A5Ci0DkKgZOky/JJMSEIaLaSJzZkYEalNvLe/jSY81xrr2qYVOyI1BWkIlZeN9OmwPkTTWi/wC1ycvbet32WDQOQoaRyFV7F9KAYYXw6dpJiH7ONGOkBhfXrPhpsacYPOXVZvlcYhMI1M4JaJkIvdGIFz5caa0R+NkStr9O/XBM6ByFMM3wWHZNc4ULHuJCxjKX2JDqQVv61FYfN8fMvaw4WNYjugmkKyOvgdKqQt/Om+bZ9HLgsT2sJ1xACWByV3JFrMvFTxBHKprRpeJPUk/dOmrRP4bKoERUSNQquJBb6fHWTxLeZpeb4ZpYJYkYK0iMgZhcLqFibeOxNRmZ560bRwYeLtZ3QME1aUROGqRvAX25muTZxioCGxkMYiJAMkLs2gk2GtWA7vmKutEXizf2Vq3+hMRZXEsKYfQOzjVVVeQQWW1uB24ilYfLokDKqCz+1e7FvDvFrk1yTH3xHY2Fuz1hveB+ulZtjTCqsADd0Tfb2ja9XUuTl8UrUe2JXJMOLnsgSQVJYsx0sLFbk7LbwqQUWFh4VAS5xiGklEMKtHCdLFmId2tciNQPtqaws2tFfSV1AHSwsRfwI50Uk+C5MMoK2dqKhQrRzOY4VHZ48OmOOZmXtZAsbLcESWLCxHDgeO1SS8K4Y7AxzoY5UDqSDY8xwII3B8xWWtjeOSjJNkDJiJVkkwjuJbwNIrWAcAHTZ7bH1sKkejWMRsJCwYWWNQTfgVFiDysQa65XkkGHLGJLM1tTEs7EDgCzEm3lTTEdEsE7l2gF2N2ALKrHmyA6T7xWFGS3PTPLhmtLvrelu+9rKNjcaj4PHzL3kOYRMPxlDRcPW311pWAzCKWMSxupQi97jbyPK1cTkWG0MnZLpd1dlFwC620t7tI+FNMV0RwUjF2gF2N2CllVj+MqkA+8UjCUTpm8jBlVO1T/AD6S+xU8ygbFDMpoAWjPYKLcJTAdUmnnttfyq+ZZmEU0SyRsChUeI28jyIrvhsOkahEUKqiwVQAAPIVE4rong5GLtCAW3bSzIGP4wUgGii4u0YyeRjyrTK0lx30lv+xH9IcfHisLP2F5BC6ayFOltDBmVT8+w5VYsHjY5EEiOpQgEEEWt58qXhMJHEgjjRURRYKoAAHpUViOimDdizQjc3IBZVJ81U2NWpJ2jDniktDtJPbsrmNcSR5lOm8TmNFYcHaNdLsOYubX/Fq9wDur6D7K4tl8Ri7HQvZ2toAstuVhTgbUjCiZs6yJJLj+KS+xQcniw8kPyecsrPjMWYXQlSjq7HZx7JsT60WamdkxWAMhxHZRxSh7DWU13aJ7bFrKfW9W+XIsM0ZiMSlGdnI39tjcsDe4N/EUvKcogwylYYwmo3Y7ksebMSSffWfjfB6X5sLcqd3aX1vn6Cstx8UsSyRspUqPEbeR5WqtdKs4ixGBxghJYRAKz27ha4uFb51vG1S+M6KYKVi7wLqO7aSy6vygpAPvp8cqg7H5P2S9ja3ZgWW3KwrTUmqOEcmGE1NW3af5f2QGCdYcexkOnt4IhEx4Ep7SA8+Bt5076a46NMJKhILyqY40G7O791Qo9TepbG5dFMnZyxq6bd1hcC3C3I+dMsu6M4SB+0jhUOODElyPySxNvdU0tKka+fHKSySu117rj8hlgwYcVCshsWwwW58WTTcetK6X49FEMdxqeeKw8bBgSfTgPfUzj8vimXTKgcXuL+B5g8QaZwdHMKnCFdypubsbqbruTfY70cXVIRz43JTldroaYuBG7XEQStC6ltd/YYpt31PpxFSWQ44z4eKZhYuoJFIx2R4eZtUkQYnjuQGt9IA2PvqRRQAABYDYAbADkKsYtM55csJQSXP8fQOhQoV0PMc14VUetjNZsLlsk2HkMcgeIBltcBmAPHyq3LVE67/5pl/OQ/fFEQyvov1m4+PFQNisTJJAXAkVtOkoe6W2Hzb391ekVNxccDuD5V54k6Odv0dixKr+Ew0szcNzEz2f3DY+6tR6oOkPyzLowxvJB+CfmdI7je9bfA1QXeio6KoA6wTrD6wsZ8umjweIeOKHuWS1mZPbc7H5xI91a309z4YHAzT/ADgumMc5H7q/Am/urG+inR9lyfHY6Qd+dCkZPHTfvN72+yqgzQepXPMRi8LM+JlaVln0hmtcLoQ22HMmtBK+vxrLP3PN/kWI/rH/AG0FaPmGcYfD2E80cRPDW6rf0vUYHgTzPxNDR5n4mgHFtVxa17+FuN/SmWX53hp2KwzxSsBcqjqxA4XIB4UA90evxNDR6/E1EZ10rwWEOnEYmONvok3b9EXNMMF1iZXKwRMXHqJsA2pLn1YAUoFm0eZ+JoaPX4mjRwwBUgg8CDcH30dAJ0+Z+JoBPM/E0oCmWaZxh8MurETRxDm7Bb+gPGgHejzPxNHo8z8TVWXrHyotpGMjv6Pb46asOX5lDOuqGVJBzRgfjyoDMeuDpNisHicOmHmdFkjYsAeJDAA7+Vabk8pbDwsxuzRxknmSoJNYv+6GNsThD/q5PvCtj6PH+C4f8zF90UBIUKFCgOSVSOum371S3+nH9u1XVDVI66z/ABVJ+cj+2iArqkhWTJ4kYXVhIrDndiDVG6vpGyrOpsA5tHMSq34eLxH4ErV76mTfK4fV/vGqv17ZOyGDMYtnjYIxHrqjY+hFvfVBsFCovovnC4zCQ4lf84gJHJuDD3G9O8yxiwxPK5sqKWPoBeoDJet/GNjcbhcriPzg0lvAnn6Lc1del+XpDlTwoAESMKB5CqN1QYRsbjsTmco4sVS/Ntz8BYVoPWQbZfP+T+uqQr/UVHbLz5yuagevxAWgPiCPherF1IfzcPzj/bVb6/OMH/njUHRrGH3ww84R9yvLvRTPsThXkXCg9tOohQjdl1ML6R4sbAA+Feo8Af4MnLsl+6Kwjqey1JM5diAVgEzr+Vq0KfcGNVFLLkHUqrKJMfiJGlfvMkZGxP0pGBLHzp1m3UfhWU/Jp5Y3tt2mmRSfOwBFatR1AefOiHSbF5NjfkOMJ7LUFYEkhQ3syRsfm16BUg7jcHhWM/uictW2FxIFmJeJjzFta39O98a0Tq+zAy5ZhZXNz2IDH8i6n7tAV/rW6wv3uUQQWbEyC++4iQ8GI8WPgPfWfdFurbHZqfleMmaNH3DyXeWQHe6qT3V5X9wpl0Vwv7852zzd6Mu8zqeBijICJ6boPjXpFRbYbAVQZf8A+h+A027bEavpak+zTaqxm/QTMcnb5VgpmmiTdwoIdVHHUl+8PMVvFAipYPL3WL0xGZHDvpKvFGyvfgSSCCPga9H9Gz/BMP8AmYvuivO/XD0aXBY49kNMU69qgHBTezqPK+/vr0J0Ua+Cwx/1EX3BVYJahRUdQo3SqR11/wA1SfnI/tq6oao/Xef4qf8AOxfbRED6j5L5WnlJIPr/AMatHS3KBi8JNhz89CB5MN1PxtVS6h/5r/40v/TWi1QY31B54R2+XyGzITIgPh82RfcQD7zUp1756YsImFQ9/ENuBx0Lx+JsKqXTSI5RnqYtQRFK3a7DYhu7MtvHff8A3hSMNif37z5GFzh4iGF7i0Ue9yPN7UBrfV5kXyLAwxEd7SGf8ttzXPrLa2XT+g+2rPVV60f5tn9F+8KgZDdRv83/APEeq91+/wCZ/wDPGp/qLb+LyOUjVAdfp3h+P11TPRq2EP8ABU/Mj7tYx1GC2aYr81J/zVrZsH//ACp+ZX7tY11Hn+NMV+ak/wCYtDRu9ChQqAyn90MP4Hh/6x/23qe6rULZLCo4mOYD3u4qC/dDj+BYf+sf9t6sXU9/NGG9JP8AmPQGW9QcvZ5lJG2zNBIv+8rqSPqPwr0LXnrp/ls2T5quNhH4OSQyod7aj/KxN63J9D5VtnRfpLh8fCJYHB27yfOQ+II9fGjBM0KFMs4zWHCxNPO4SNBck+PIAeJPKgMa/dGSr2uEX5wSUnyBKgfWD8K1noaf4BhP6vD9wV5j6c9JHzHFyYkghT3Y1PzY19keu9z5mvTHQZr5dgz/ALPD90VWUnKOioVkDRKrXWbkU+Oy9sPhwGkMkbAEhRZTc7mrFEacxGqiFT6quj8+BwPYYhQr9q7WVgw0tptuPQ1caKhVBSutboi+Y4VVhCmeJwyajpBU7Ot/Dax91MOqHoPLlyzSYkKJpCFGlg1o134jxLH6hWiUKAOq/wBPMslxOBlhhAMjBdIJA4EHian6FQFG6pOj+JwWGkixSBGMpZQGDXUgcuG96jOtzojjMc8RwyBgqm93VbG/nWls1qJGvVJQ1weHZcOsZ9oRBT66bfbWbdV3QfG4LHTT4hEVHR1Uq6sbs4YbDyFatQoUOhQoVAUXrd6M4jMMLFFhlVnSYOdTBRp0OvE+ZFSvV1lEuDy+HDzgCRNeoAhhu7MNx5EVZaKgGGeZNBjIWgxCB0bw8QfBlPgw51i+c9VuY4KTtstlaRRuNDdnMo5EXAf3fCt3oUBgH+VPSaMdmY5yeF2w2pviFsa4YXoXnebSq2NMiID7eI7ukePZxc/cPWvQ9FSwYf1ndX8kcODgy/DySrGJe0ZV1Mzto7z28TY/CtU6EYd48vwkcilXSCNWVhYqwUAgjwNTlFQAo6FCoUjIH2p1EaFCiIdgaO9ChVAV6ANChQAo70KFAA0Yo6FAChQoUAKFHQoAUKFChQUVHQoQKhQoUKCitQoUIHQoUKhT/9k=",
//                "Self Improvement Book"));
//        books.add(new Book("The Worst President in History"," Matt Margolis",386,
//                "https://m.media-amazon.com/images/I/513mxL7badL._SL500_.jpg",
//                "Self Improvement Book"));

        Util util = new Util();
        ArrayList<Book> books = new ArrayList<>();
        books = util.getButton1();
        adapter.setBooks(books);



    }
}
