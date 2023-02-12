package com.utsman.binarku

import android.content.DialogInterface
import android.content.DialogInterface.OnClickListener
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.utsman.binarku.databinding.ActivitySixBinding
import com.utsman.binarku.databinding.LayoutDialogBinding

class SixActivity : AppCompatActivity() {

    private val binding: ActivitySixBinding by lazy {
        ActivitySixBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnStandard.setOnClickListener {
            standard()
        }

        binding.btnStandardAction.setOnClickListener {
            standardWithAction()
        }

        binding.btnCustom.setOnClickListener {
            customLayout()
        }

        binding.btnDialogFragment.setOnClickListener {
            dialogFragment()
        }
    }

    private fun standard() {
        /*val dialog = AlertDialog.Builder(this)
        dialog.setTitle("standard dialog")
        dialog.setMessage("ini message nya")

        dialog.show()*/

        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setTitle("standard dialog")
        dialogBuilder.setMessage("ini message nya")

        val dialog = dialogBuilder.create() // ini jadi alert dialog
        dialog.show() // show() ini juga ada di dialogBuilder
    }

    private fun standardWithAction() {
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setTitle("standard dialog")
        dialogBuilder.setMessage("ini message nya")
        dialogBuilder.setIcon(R.drawable.ic_launcher_background)

        /*dialog.setPositiveButton("ok") { dialogInterface, which ->

        }*/
        /*dialog.setPositiveButton("ok", object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {

            }
        })*/

        /*dialog.setPositiveButton("ok", object : OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {
                // ini click
                toast("ini dialog positif")
            }
        })*/

        /*dialog.setPositiveButton("ok") { _, _ ->
            toast("ini positif button")
        }*/

        dialogBuilder.setPositiveButton("ok") { _, _ ->
            toast("action positive")
        }

        dialogBuilder.setNegativeButton("cancel") { _, _ ->
            toast("action negative")
        }

        dialogBuilder.setNeutralButton("later") { _, _ ->
            toast("action netral")
        }

        val dialog = dialogBuilder.create()
        dialog.show()
    }

    private fun customLayout() {
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setCancelable(false)

        val view = LayoutInflater.from(this).inflate(R.layout.layout_dialog, null, false)
        val dialogBinding = LayoutDialogBinding.bind(view)
        dialogBuilder.setView(view)

        val dialog = dialogBuilder.create()

        dialogBinding.dialogTitle.text = "ini title dari binding"
        dialogBinding.btnClose.setOnClickListener {
            dialog.dismiss() // dismiss cuman ada di class AlertDialog
        }

        dialog.show() // show ada di class AlertDialog.Builder dan AlertDialog
    }

    private fun dialogFragment() {
        val dialogFragment = SimpleDialogFragment()
        dialogFragment.isCancelable = false

        dialogFragment.show(supportFragmentManager, "dialog-fragment")
    }
}

// implement onclick listener sebagai kelas
class DialogClick : DialogInterface.OnClickListener {
    override fun onClick(dialog: DialogInterface?, which: Int) {
        // action click
    }
}