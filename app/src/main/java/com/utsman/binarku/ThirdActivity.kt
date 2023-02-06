package com.utsman.binarku

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.utsman.binarku.databinding.ActivityThirdBinding
import com.utsman.binarku.fragments.CatFragment
import com.utsman.binarku.fragments.DogFragment

class ThirdActivity : AppCompatActivity() {

    private val binding: ActivityThirdBinding by lazy {
        ActivityThirdBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val containerFirst = binding.fragmentContainerCat.id
        val containerSecond = binding.fragmentContainerDog.id

        val fragmentTransaction = supportFragmentManager.beginTransaction()

        val catFragment = CatFragment()
        val dogFragment = DogFragment()

        // instance 1
        fragmentTransaction().add(containerFirst, catFragment)
            .commit()

        // instance 2
        fragmentTransaction().add(containerSecond, dogFragment)
            .commit()

        val animalPagerAdapter = AnimalPagerAdapter(supportFragmentManager)
        animalPagerAdapter.addFragment(CatFragment())
        animalPagerAdapter.addFragment(DogFragment())

        binding.vpAnimal.adapter = animalPagerAdapter
    }

    private fun fragmentTransaction(): FragmentTransaction {
        return supportFragmentManager.beginTransaction()
    }
}